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
		private Integer[] array;

		private Integer sum;

		private Integer arrayLen;

		public TestCase(Integer arrayLen, Integer sum) {
			this.arrayLen = arrayLen;
			this.sum = sum;
			this.array = new Integer[arrayLen];
		}

		public void initArray(String elements) {
			this.array = Stream.of(elements.split(" ")).map(Integer::valueOf).collect(Collectors.toList())
					.toArray(new Integer[0]);
		}

		public String findFirstOccurenceOfSubArray() {
			for (int startIdx=0; startIdx<arrayLen; startIdx++) {
				for (int endIdx = arrayLen-1; endIdx>startIdx; endIdx--) {
					int cursor = startIdx;
					int sum = 0;

					while (cursor <= endIdx) {
						sum += array[cursor];
						if (sum == this.sum) {
							return String.format("%d %d", startIdx + 1, cursor + 1);
						}
						cursor++;
					}
					
					if (sum < this.sum) {
						break;
					}
				}
			}

			return "-1";
		}
	}
}
