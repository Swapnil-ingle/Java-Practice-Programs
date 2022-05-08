package com.swapnil.java.practice.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubArrayWithGivenSumMain {

	public static void main(String[] args) {
		SubArrayWithGivenSumMain driver = new SubArrayWithGivenSumMain();

		List<TestCase> testCases = driver.genTestCases();
		testCases.forEach(tc -> System.out.println(tc.findFirstOccurenceOfSubArray()));
	}

	private List<TestCase> genTestCases() {
		Scanner in = new Scanner(System.in);
		Byte totalTestCases = Byte.valueOf(in.nextLine());
		List<TestCase> testCases = new ArrayList<>();

		try {
			for (byte i = 0; i < totalTestCases; i++) {
				String[] inp = in.nextLine().split(" ");
				TestCase tc = new TestCase(Integer.valueOf(inp[0]), Integer.valueOf(inp[1]));
				tc.initArray(in.nextLine());

				testCases.add(tc);
			}
		} catch (Exception e) {
			System.out.println("Exception occured while generating test cases.");
			e.printStackTrace();
		} finally {
			in.close();
		}

		return testCases;
	}

	private class TestCase {
		private Integer[] arr;

		private Integer sum;

		private Integer arrLen;

		public TestCase(Integer arrLen, Integer sum) {
			this.arrLen = arrLen;
			this.sum = sum;
			this.arr = new Integer[arrLen];
		}

		public void initArray(String elements) {
			this.arr = Stream.of(elements.split(" ")).map(Integer::valueOf).collect(Collectors.toList())
					.toArray(new Integer[0]);
		}

		public String findFirstOccurenceOfSubArray() {
			int header = 0, wsum = 0;

			for (int i = 0; i<arrLen; i++) {
				wsum += arr[i];

				while (wsum > this.sum) {
					wsum -= arr[header];
					header++;
				}

				if (wsum == sum) {
					return String.format("%d %d", header + 1, i + 1);
				}
			}

			return "-1";
		}
	}
}
