/**
 * 
 * @author Swap
 * 
 * Solution for 'Cracking The Coding Interview' Chapter 1 - Ex#4
 * 
 * PalindromePermutation(input)
 *
 */
public class PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(palindromePermutation("Taco Cat"));
	}

	private static boolean palindromePermutation(String input) {
		int bitVector = 0;

		for (char c : input.toLowerCase().toCharArray()) {
			int letterNum = getAlphabetNum(c);
			
			if (letterNum < 0) {
				continue;
			}
			
			bitVector = toggleNthBit(bitVector, letterNum);
		}
		
		return doesBitVectorHasAtmostOneSetBit(bitVector);
	}
	
	/**
	 * We want to toggle the Nth MSB of the number.
	 * At the same time, we want every other bit to remain the same.
	 * 
	 * So we want such a filter (AND/OR/etc) that will toggle a bit if matched with certain bit (say '1')
	 * and will keep it the same matched with other bit (say '0').
	 * 
	 * You can achieve this using XOR (^) operator; according to XOR's truth table. 
	 * Whatever bit was matched with 1 will be toggled and whatever bit was matched with '0' will remain as it is.
	 * 
	 * Let's take an example, a number 9, where we want to 4th MSB.
	 * 
	 * 9 		--> 0000 1001
	 * Result 	--> 0000 0001
	 * 
	 * We want to match the 4th MSB with '1' against an XOR gate and all the rest MSBs with 0.
	 * Basically we want to match 9 with 0000 1000 (Note 1 is in the k'th place which we want to toggle, and everything else is 0)
	 * 
	 * This (0000 1000) can be called as a 'mask' number which we will XOR with the existing number to toggle
	 * the k'th bit in the existing number.
	 * 
	 * How to obtain the mask? Left-Shift 1 to (k-1)th position so that we will get an integer where the k'th
	 * bit is 1 while all others are 0.
	 * 
	 * @param bitVector
	 * @param k
	 * @return
	 */
	private static int toggleNthBit(int bitVector, int k) {
		int mask = 1 << (k - 1);
		return bitVector ^ mask;
	}

	private static int getAlphabetNum(char c) {
		int letterNum = c - 96;
		
		if (letterNum > 26 ) {
			return -1;
		}
		
		return letterNum;
	}
	
	private static boolean doesBitVectorHasAtmostOneSetBit(int bitVector) {
		return bitVector == 0 ? true : ((bitVector - 1) & bitVector) == 0 ? true : false;
	}
}
