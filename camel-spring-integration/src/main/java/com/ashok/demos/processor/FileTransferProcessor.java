package com.ashok.demos.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileTransferProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		String lines = (String)exchange.getIn().getBody();
		System.out.println("In process "+lines);
	}

}
