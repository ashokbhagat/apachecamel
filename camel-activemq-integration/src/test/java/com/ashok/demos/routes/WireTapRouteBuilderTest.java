package com.ashok.demos.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class WireTapRouteBuilderTest {
	public static void main(String[] args) {
		RouteBuilder routeBuilder= new WireTapRouteBuilder();
		CamelContext ctx = new DefaultCamelContext();
		
	
        try {
            ctx.addRoutes(routeBuilder);
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        
	}
}
