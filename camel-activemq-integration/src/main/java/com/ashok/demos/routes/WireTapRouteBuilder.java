package com.ashok.demos.routes;

import org.apache.camel.builder.RouteBuilder;

public class WireTapRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:E:/workspace_mars/testing/apache-camel/source?noop=true").
		to("direct:wiretaproute");
		
		from("direct:wiretaproute")
		.wireTap("file:E:/workspace_mars/testing/apache-camel/move")
		.to("direct:normalroute");

		from("direct:normalroute")
		.to("file:E:/workspace_mars/testing/apache-camel/target");
		

		/*from("direct:test").choice()
			.when(body().contains("Line1")).to("jms:queue:Line1")
			.when(body().contains("Line2")).to("jms:queue:Line2")
			.when(body().contains("Line3")).to("jms:queue:Line3")
			.otherwise().to("jms:queue:LineOtherwise");*/
	}

}
