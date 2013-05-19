public class LuckyRemainder {
	public static void main(String[] args) {
		int a = getLuckyRemainder("11235813213455");
		System.out.println(a);
	}
	public static int getLuckyRemainder(String arg) {

		Long superSum = 0L;
		int[] splitData = new int[arg.length()];
		for (int i = 0; i < arg.length(); i++) {
			splitData[i] = Integer.valueOf(arg.substring(i,  i+1));
		}

		for (int pointer = (int) (Math.pow(2, arg.length()) - 1); pointer > 0; pointer--) {
			String add = "";
			for (int a = 0; a < arg.length() ; a++) {
				if (((pointer & (1 << a)) > 0)) {
					add += splitData[a];
				}
			}
			superSum+=Long.valueOf(add);
		}


		return (int) (superSum % 9);
	}
}
