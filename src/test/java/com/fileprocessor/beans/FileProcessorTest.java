package com.fileprocessor.beans;

import java.io.IOException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FileProcessorTest {

	long expectedChars;
	long expectedWords;
	long actualChars;
	long actualWords;
	FileProcessor fileProcessor;
	FileManagerHelper fileManagerHelper;

	@Before
	public void setUp() throws IOException {
		expectedChars = 26;
		expectedWords = 4;
		actualChars = 0;
		actualWords = 0;
		fileManagerHelper = new FileManagerHelper();
		fileProcessor = new FileProcessor(fileManagerHelper.createTempFile("TestFile", "JUnit is Awesome Framework"));
	}

	@Test
	public void testChars() {
		actualChars = fileProcessor.chars();
		assertEquals(expectedChars, actualChars);
	}

	@Test
	public void testWords() {
		actualWords = fileProcessor.words();
		assertEquals(expectedWords, actualWords);
	}

	@After
	public void tearDown() {
		fileProcessor = null;
	}
}
