package com.swapnil.griffith.testing;

import java.util.Scanner;

public class HoleIDGeneratorVer2 {
	private static char alphabet[] = {65, 66, 67, 68, 69, 70, 71, 72};
	
	private static int MAX_HOLE_IN_A_ROW = 12;
	
	private static int MAX_ROWS = 8;
	
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Number of total specimen?");
			int totalSpecimen = sc.nextInt();
			int currSpcmnIdx = 0;
			
			while (currSpcmnIdx < totalSpecimen)  {
				generateHoleIds(currSpcmnIdx);
				currSpcmnIdx++;
			}
		} catch (Exception e) {
			System.out.println("Error while generating hole ID");
		} finally {
			sc.close();
		}
	}

	private static void generateHoleIds(int currSpcmnIdx) {
		int rowNumber = (currSpcmnIdx / MAX_HOLE_IN_A_ROW) % MAX_ROWS;
		int HoleNumber = (currSpcmnIdx % MAX_HOLE_IN_A_ROW) + 1;
		
		System.out.println(alphabet[rowNumber] + "-" + HoleNumber);
	}
}
