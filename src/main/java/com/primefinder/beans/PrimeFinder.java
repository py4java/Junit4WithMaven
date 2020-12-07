package com.primefinder.beans;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinder {

	List<Integer> lprimes = null;
	Integer[] primes = null;
	int count = 0;

	public Integer[] primes(int n) {
		lprimes = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			int k = 0;
			for (int j = 2; j <= i; j++) {
				if (i % j == 0)
					k++;
			}
			if (k == 1) {
				lprimes.add(i);
				count++;
			}
		}
		primes = new Integer[count];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = lprimes.get(i);
		}
		return primes;
	}
}
