package com.ashok.demos.routes;

import org.apache.camel.builder.RouteBuilder;

import com.ashok.demos.processor.FileTransferProcessor;

public class FileTransferRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:E:/workspace_mars/testing/apache-camel/source?noop=true").split().tokenize("\n").process(new FileTransferProcessor())
		.to("file:E:/workspace_mars/testing/apache-camel/target");
	}

}
