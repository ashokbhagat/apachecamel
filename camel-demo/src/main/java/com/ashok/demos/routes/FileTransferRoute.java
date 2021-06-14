package com.ashok.demos.routes;

import java.util.Hashtable;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * @author Ashoka
 *File transfer from source to target. preMove is used to move file before processing.
 */
public class FileTransferRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {	
		System.out.println("Inside route 1");
	
		
		from("file:E:/workspace_mars/testing/apache-camel/source?noop=true").process(new Processor(){
			public void process(Exchange exchange) throws Exception {
				System.out.println("Inside first processor");				
			}			
		})
		.to("file:E:/workspace_mars/testing/apache-camel/target1");
	}

}
