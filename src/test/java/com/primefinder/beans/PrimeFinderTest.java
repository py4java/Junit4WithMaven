package com.primefinder.beans;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PrimeFinderTest {

	int n;
	Integer[] expectedPrimes;
	PrimeFinder primeFinder;

	@Parameters
	public static List<Object[]> getParameters() {
		return Arrays.asList(new Object[][] { { 10, new Integer[] { 2, 3, 5, 7 } },
				{ 20, new Integer[] { 2, 3, 5, 7, 11, 13, 17, 19 } }, { 2, new Integer[] { 2 } } });
	}

	public PrimeFinderTest(int n, Integer[] expectedPrimes) {
		this.n = n;
		this.expectedPrimes = expectedPrimes;
		primeFinder = new PrimeFinder();
	}

	@Test
	public void testPrimes() {
		Integer[] actualPrimes = null;
		actualPrimes = primeFinder.primes(n);
		assertArrayEquals(expectedPrimes, actualPrimes);
	}
}
