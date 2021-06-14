package com.ashok.demos.routes;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMQContentBasedAnotherRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//from("file:E:/workspace_mars/testing/apache-camel/source?noop=true").split().tokenize("\n").to("direct:test");

		from("direct:test").choice()
			.when(body().contains("Line1")).to("jms:queue:Line1")
			.when(body().contains("Line2")).to("jms:queue:Line2")
			.when(body().contains("Line3")).to("jms:queue:Line3")
			.otherwise().to("jms:queue:LineOtherwise");
	}
}
