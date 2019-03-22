package com.swapnil.java.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CostOfTile {

	public static void main(String[] args) {
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			
			float tileWidth = getTileWidth(sc);
			float tileHeight = getTileHeight(sc);
			float floorWidth = getFloorWidth(sc);
			float floorHeight = getFLoorHeight(sc);
			float costOfTile = getSingleTileCost(sc);
			
			float floorArea = floorHeight * floorWidth;
			float tileArea = tileHeight * tileWidth;
			
			System.out.println("The total cost for tiling" 
					+ " (" + floorHeight + "X" + floorWidth + ") " + "floor is: " 
					+ calculateTotalTileCost(floorArea, tileArea, costOfTile) + " Unit.");
		} catch (InputMismatchException e) { 
			System.out.println("Please enter valid input. \nError: " + e);
		} catch (Exception e) {
			System.out.println("Error while processing cost: " + e);
		} finally {
			sc.close();
		}
	}

	private static float calculateTotalTileCost(float floorArea, float tileArea, float costOfTile) {
		return (floorArea / tileArea) * costOfTile;
	}
	
	private static float getTileWidth(Scanner sc) {
		System.out.println("Enter the widht of tile");
		return getInput(sc);
	}

	private static float getTileHeight(Scanner sc) {
		System.out.println("Enter the height of tile");
		return getInput(sc);
	}

	private static float getFLoorHeight(Scanner sc) {
		System.out.println("Enter the height of floor plan");
		return getInput(sc);
	}

	private static float getFloorWidth(Scanner sc) {
		System.out.println("Enter the width of floor plan");
		return getInput(sc);
	}

	private static float getSingleTileCost(Scanner sc) {
		System.out.println("Enter the Cost of a single tile");
		return getInput(sc);
	}
	
	private static float getInput(Scanner sc) {
		return sc.nextFloat();
	}
}
