package com.ashok.demos.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("{{route.start}}").to("{{route.end}}");
	}

}
