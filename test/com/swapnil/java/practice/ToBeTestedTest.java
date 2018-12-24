package test.com.swapnil.java.practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.swapnil.java.practice.ToBeTested;

class ToBeTestedTest {

	@Test
	void addtest() {
		ToBeTested obj = new ToBeTested();
		int output = obj.addNum(1, 3);
		assertEquals(output, 4);
	}
	
	@Test
	void concattest() {
		ToBeTested obj = new ToBeTested();
		String output = obj.concatString("a", "b");
		assertEquals(output, "ab");
	}
}
