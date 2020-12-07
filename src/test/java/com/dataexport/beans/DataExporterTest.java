package com.dataexport.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataExporterTest {

	boolean expectedOutcome;
	String source;
	String destination;
	DataExporter dataExporter;

	@Before
	public void setUp() {
		expectedOutcome = true;
		source = "urbanladderdb";
		destination = "urbanladdertestdb";
		dataExporter = new DataExporter();
	}

	/**
	 * @throws InterruptedException ; Performance Testing
	 */
	@Test(timeout = (1000 * 4))
	public void testExport() throws InterruptedException {
		boolean actualOutcome = false;

		// long startTime = System.currentTimeMillis();

		actualOutcome = dataExporter.export(source, destination);

		/*
		 * long endTime = System.currentTimeMillis(); if ((endTime - startTime) > 15)
		 * fail("Failed took more than 15 sec");
		 */

		assertEquals(expectedOutcome, actualOutcome);
	}

	@After
	public void tearDown() {
		dataExporter = null;
	}
}
