package com.arrayhelper.beans;

import com.arrayhelper.exception.EmptyArrayException;

public class ArrayHelper {

	public int[] filterDuplicates(int[] inArray) {
		int[] outArray = null;
		int[] tmpArray = null;
		boolean found = false;
		int length = 0;

		try {
			tmpArray = new int[inArray.length];
			for (int i = 0; i < inArray.length; i++) {
				found = false;
				if (i == 0) {
					tmpArray[i] = inArray[i];
					length++;
					continue;
				}
				for (int j = 0; j < length; j++) {
					if (tmpArray[j] == inArray[i])
						found = true;
				}
				if (found == false) {
					tmpArray[length] = inArray[i];
					length++;
				}
			}
			outArray = new int[length];
			for (int i = 0; i < length; i++) {
				outArray[i] = tmpArray[i];
			}

		} catch (NullPointerException e) {
			throw new EmptyArrayException("Empty Array");
		}

		return outArray;
	}
}
