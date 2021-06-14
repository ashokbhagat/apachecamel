package com.ashok.demos.routes;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMQRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("file:E:/workspace_mars/testing/apache-camel/source?noop=true").split().tokenize("\n")
				.to("jms:queue:ashokqueue");

	}

}
