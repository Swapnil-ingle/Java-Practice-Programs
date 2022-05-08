package com.swapnil.java.practice.random;

import java.util.ArrayList;
import java.util.List;

public class UnitFractions {

	public static void main(String[] args) {
		List<String> tuples = new ArrayList<>();
		split(1f, 1f, 1f, 1f, tuples);
		System.out.println("Num of unit-fractions 4-Tuples are (" + tuples.size() + ")");
		tuples.forEach(tuple -> System.out.println(tuple));
	}

	/**
	 * 
	 * Enumerate all sets of 4 possible unit-fractions which add up to 1.
	 * 
	 * 1 = (1/a) + (1/b) + (1/c) + (1/d); Find all sets of (a, b, c, d) Given that,
	 * (a,b,c,d) are positive integers and (a <= b <= c <= d)
	 * 
	 * @param a      Initial value 1
	 * @param b      Initial value 1
	 * @param c      Initial value 1
	 * @param d      Initial value 1
	 * @param tuples The set of all (a,b,c,d)
	 * 
	 * @return int
	 */
	private static int split(float a, float b, float c, float d, List<String> tuples) {
		if (a > 20 || b > 20 || c > 20 || d > 20) {
			// Arbitrary upper-bound on the parameters or they will
			// infinitely increment.
			// Reason: Once 'a' becomes > 20 the fractions is so small that the
			// four unit fractions will never add up to 1, given the init condition
			// (a <= b <= c <= d).
			return 0;
		}

		if (((1 / a) + (1 / b) + (1 / c) + (1 / d)) < 1) {
			return 0;
		}

		if (1 == ((1 / a) + (1 / b) + (1 / c) + (1 / d))) {
			if (!tuples.contains(String.format("(%.0f, %.0f, %.0f, %.0f)", a, b, c, d))) {
				tuples.add(String.format("(%.0f, %.0f, %.0f, %.0f)", a, b, c, d));
			}
			return 0;
		}

		return split(a + 1, b + 1, c + 1, d + 1, tuples) + split(a, b + 1, c + 1, d + 1, tuples)
				+ split(a, b, c + 1, d + 1, tuples) + split(a, b, c, d + 1, tuples);
	}

}
