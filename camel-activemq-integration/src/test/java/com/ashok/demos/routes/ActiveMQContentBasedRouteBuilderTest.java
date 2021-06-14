package com.ashok.demos.routes;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class ActiveMQContentBasedRouteBuilderTest {
	public static void main(String[] args) {
		RouteBuilder activeMqrouteBuilder= new ActiveMQContentBasedRouteBuilder();
		RouteBuilder activeMqrouteAnotherBuilder= new ActiveMQContentBasedAnotherRoute();
		
		CamelContext ctx = new DefaultCamelContext();
		
		//configure jms component        
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        
        try {
            ctx.addRoutes(activeMqrouteBuilder);
            ctx.addRoutes(activeMqrouteAnotherBuilder);
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        
	}
}
