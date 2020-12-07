package com.fileprocessor.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fileprocessor.exception.FileReaderException;

public class FileProcessor {

	private File inFile;

	public FileProcessor(File inFile) {
		this.inFile = inFile;
	}

	public long chars() {
		long chars = 0;
		char[] buffer = null;
		StringBuilder builder = null;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));) {
			buffer = new char[256];
			builder = new StringBuilder();
			while (bufferedReader.read(buffer) != -1) {
				builder.append(buffer);
			}
			if (builder.length() > 0) {
				chars = builder.toString().trim().length();
			}
		} catch (IOException e) {
			throw new FileReaderException("Unable To Read File", e);
		}

		return chars;
	}

	public long words() {
		long words = 0;
		char[] buffer = null;
		StringBuilder builder = null;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));) {
			buffer = new char[256];
			builder = new StringBuilder();
			while (bufferedReader.read(buffer) != -1) {
				builder.append(buffer);
			}
			if (builder.length() > 0) {
				words = builder.toString().trim().split(" ").length;
			}
		} catch (IOException e) {
			throw new FileReaderException("Unable To Read File", e);
		}

		return words;
	}
}
