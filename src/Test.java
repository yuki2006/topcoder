import java.util.Arrays;
import java.util.HashSet;

public class Test {
	public static int[] unique(int[] values) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int string : values) {
			set.add(string);
		}

		int[] result = new int[set.size()];
		int i = 0;
		for (int value : set) {
			result[i] = value;
			i++;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char c = 'a';
		System.out.println(0 + c + "");

		int[] test = { 10, 3, 4, 5, 6, 10, 8, 9, 10, 5 };
		int[] unique = unique(test);
		System.out.println(Arrays.toString(unique));
	}

}
