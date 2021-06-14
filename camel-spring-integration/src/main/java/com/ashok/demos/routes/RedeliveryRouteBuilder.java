package com.ashok.demos.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.ashok.demos.exception.CamelCustomException;

public class RedeliveryRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		onException(CamelCustomException.class).process(new Processor(){

			public void process(Exchange exchange) throws Exception {
				System.out.println("handling ex");
			}			
		}).redeliveryPolicyRef("testRedeliveryPolicyProfile").log("Received body ${body}").handled(true);
		
		from("file:E:/workspace_mars/testing/apache-camel/source?noop=true").split().tokenize("\n").process(new Processor(){

			public void process(Exchange exchange) throws Exception {
				String lines = (String)exchange.getIn().getBody();
				System.out.println("In process "+lines);
				throw new CamelCustomException();				
			}
		
		}).to("file:E:/workspace_mars/testing/apache-camel/target");
	}

}
