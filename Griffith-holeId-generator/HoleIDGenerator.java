package com.swapnil.griffith.testing;

import java.util.Scanner;

public class HoleIDGenerator {
	private static char alphabet[] = {65, 66, 67, 68, 69, 70, 71, 72};
	
	private static int MAX_HOLE_IN_A_ROW = 12;
	
	private static int MAX_ROWS = 8;
	
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Number of total specimen?");
			int totalSpecimen = sc.nextInt();
			generateHoleIds(0, 0, totalSpecimen);
		} catch (Exception e) {
			System.out.println("Error while generating hole ID");
		} finally {
			sc.close();
		}
	}

	private static void generateHoleIds(int currentAlphaIdx, int currentSpecmnIdx, int totalSpecimen) {
		if (currentSpecmnIdx >= totalSpecimen) {
			return;
		} else if (currentAlphaIdx == MAX_ROWS) {
			currentAlphaIdx = 0;
			System.out.println("<============ DELIMITER ==============>");
		}
		
		int i = 1;
		while (i <= MAX_HOLE_IN_A_ROW && currentSpecmnIdx < totalSpecimen) {
			System.out.print(alphabet[currentAlphaIdx] + "-" + i + ", ");
			i++;
			currentSpecmnIdx++;
		}
		
		System.out.println("");
		generateHoleIds(++currentAlphaIdx, currentSpecmnIdx, totalSpecimen);
	}

}
