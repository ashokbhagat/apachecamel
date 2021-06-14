package com.ashok.demos.camel;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleRouteBuilderTest extends CamelSpringTestSupport {

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("camel-context-test.xml");
	}
	
	@Test
	public void testPayoadReached() throws Exception{
		MockEndpoint mockOut = getMockEndpoint("mock:out");
		mockOut.setExpectedMessageCount(1);
		template.sendBody("direct:in", "this is test");
		assertMockEndpointsSatisfied();
	}

}
