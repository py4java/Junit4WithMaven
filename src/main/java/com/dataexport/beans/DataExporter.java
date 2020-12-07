package com.dataexport.beans;

public class DataExporter {

	public boolean export(String source, String destination) throws InterruptedException {
		Thread.sleep(1000 * 3);
		return true;
	}
}
