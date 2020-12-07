package com.arrayhelper.beans;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.arrayhelper.exception.EmptyArrayException;

public class ArrayHelperTest {

	int[] inArrayForPositiveNumbers;
	int[] expectedOutArrayForPositiveNumbers;

	int[] inArrayForSingleNumber;
	int[] expectedOutArrayForSingleNumber;

	int[] inArrayForSameArray;
	int[] expectedOutArrayForSameArray;

	int[] inArrayForNullArray;
	int[] expectedOutArrayForNullArray;

	int[] inArrayForNovalues;
	int[] expectedOutArrayForNovalues;

	int[] inArrayForTwoNumbers;
	int[] expectedOutArrayForTwoNumbers;

	int[] actualOutArray;
	ArrayHelper arrayHelper;

	@Before
	public void setUp() {
		arrayHelper = new ArrayHelper();
		inArrayForPositiveNumbers = new int[] { 10, 20, 30, 10, 40, 50, 20, 60, 30, 70 };
		expectedOutArrayForPositiveNumbers = new int[] { 10, 20, 30, 40, 50, 60, 70 };
		inArrayForSingleNumber = new int[] { 9 };
		expectedOutArrayForSingleNumber = new int[] { 9 };
		inArrayForSameArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		expectedOutArrayForSameArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		inArrayForNullArray = null;
		expectedOutArrayForNullArray = null;
		inArrayForNovalues = new int[] {};
		expectedOutArrayForNovalues = new int[] {};
		inArrayForTwoNumbers = new int[] { 16, 16 };
		expectedOutArrayForTwoNumbers = new int[] { 16 };

	}

	@Test
	public void testFilterDuplicatesWithPositiveNumbers() {
		actualOutArray = arrayHelper.filterDuplicates(inArrayForPositiveNumbers);
		assertArrayEquals(expectedOutArrayForPositiveNumbers, actualOutArray);
	}

	@Test
	public void testFilterDuplicatesWithSingleNumber() {
		actualOutArray = arrayHelper.filterDuplicates(inArrayForSingleNumber);
		assertArrayEquals(expectedOutArrayForSingleNumber, actualOutArray);
	}

	@Test
	// @Ignore // for temperory skip
	public void testFilterDuplicatesWithSameArray() {
		actualOutArray = arrayHelper.filterDuplicates(inArrayForSameArray);
		assertArrayEquals(expectedOutArrayForSameArray, actualOutArray);
	}

	@Test(expected = EmptyArrayException.class)
	public void testFilterDuplicatesWithNull() {
		actualOutArray = arrayHelper.filterDuplicates(inArrayForNullArray);
		assertArrayEquals(expectedOutArrayForNullArray, actualOutArray);
	}

	@Test
	public void testFilterDuplicatesWithNoValues() {
		actualOutArray = arrayHelper.filterDuplicates(inArrayForNovalues);
		assertArrayEquals(expectedOutArrayForNovalues, actualOutArray);
	}

	@Test
	public void testFilterDuplicatesWithTwoNumbers() {
		actualOutArray = arrayHelper.filterDuplicates(inArrayForTwoNumbers);
		assertArrayEquals(expectedOutArrayForTwoNumbers, actualOutArray);
	}

	@After
	public void tearDown() {
		arrayHelper = null;
	}
}
