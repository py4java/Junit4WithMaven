package com.fileprocessor.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManagerHelper {

	public File createTempFile(String prefix, String data) throws IOException {
		File inFile = null;
		FileOutputStream fos = null;
		try {
			inFile = File.createTempFile(prefix, ".txt");
			fos = new FileOutputStream(inFile);
			fos.write(data.getBytes());
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
		return inFile;
	}

	public void deleteFile(File inFile) {
		if (inFile != null) {
			if (inFile.isFile() && inFile.exists()) {
				inFile.delete();
			}
		}
	}
}
