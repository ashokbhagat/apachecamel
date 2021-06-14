package com.ashok.demos.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class FileTransferRouteTest {
	public static void main(String[] args) {
		FileTransferRoute fileTransfeRoute = new FileTransferRoute();
		FileTransferRoute2 fileTransfeRoute2 = new FileTransferRoute2();
		CamelContext camelContext=new DefaultCamelContext();
		try{
			camelContext.addRoutes(fileTransfeRoute);
			camelContext.addRoutes(fileTransfeRoute2);
			camelContext.start();
			Thread.sleep(5 * 60 * 1000);
			camelContext.stop();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
