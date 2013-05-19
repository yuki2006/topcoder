// Paste me into the FileEdit configuration dialog

public class SignatureDecorator {
	public String applyDecoration(String name, String[] commands,
			String[] decorations) {
		String string = new String(name);
		int i = 0;
		for (String command : commands) {
			if (command.equals("surround")) {
				string = decorations[i] + string + reverse(decorations[i]);
			} else if (command.equals("append")) {
				string += decorations[i];
			} else {
				string = decorations[i] + string;
			}
			i++;
		}
		return string;

	}

	String reverse(String data) {
		char[] charArray = data.toCharArray();
		char[] tmp = new char[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			tmp[i] = charArray[charArray.length - i - 1];
		}
		return new String(tmp);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SignatureDecoratorHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SignatureDecoratorHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SignatureDecoratorHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
			return;
		}

		int correct = 0, total = 0;
		for (int i = 0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100)
					break;
				continue;
			}
			correct += x;
			++total;
		}

		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(String expected, String result) {
		return expected.equals(result);
	}

	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}

	static int verifyCase(int casenum, String expected, String received) {
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected));
			System.err.println("    Received: " + formatResult(received));
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch (casenum__) {
		case 0: {
			String name = "Bob";
			String[] commands = { "surround", "append", "prepend" };
			String[] decorations = { "-=", "(", ")" };
			String expected__ = ")-=Bob=-(";

			return verifyCase(casenum__, expected__,
					new SignatureDecorator().applyDecoration(name, commands,
							decorations));
		}
		case 1: {
			String name = "Super_Man_01";
			String[] commands = {};
			String[] decorations = {};
			String expected__ = "Super_Man_01";

			return verifyCase(casenum__, expected__,
					new SignatureDecorator().applyDecoration(name, commands,
							decorations));
		}
		case 2: {
			String name = "4BcD3FgHIjklMN0pqrS7uVWxYZ_";
			String[] commands = { "append", "prepend", "surround" };
			String[] decorations = { "`{[(", ")]}'", ",.;<>?:|-=_+!@#$%^&*~" };
			String expected__ = ",.;<>?:|-=_+!@#$%^&*~)]}'4BcD3FgHIjklMN0pqrS7uVWxYZ_`{[(~*&^%$#@!+_=-|:?><;.,";

			return verifyCase(casenum__, expected__,
					new SignatureDecorator().applyDecoration(name, commands,
							decorations));
		}
		case 3: {
			String name = "RacEcaR";
			String[] commands = { "surround" };
			String[] decorations = { "([{/" };
			String expected__ = "([{/RacEcaR/{[(";

			return verifyCase(casenum__, expected__,
					new SignatureDecorator().applyDecoration(name, commands,
							decorations));
		}

		// custom cases

		/*
		 * case 4: { String name = ; String[] commands = ; String[] decorations
		 * = ; String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SignatureDecorator().applyDecoration(name, commands, decorations)); }
		 */
		/*
		 * case 5: { String name = ; String[] commands = ; String[] decorations
		 * = ; String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SignatureDecorator().applyDecoration(name, commands, decorations)); }
		 */
		/*
		 * case 6: { String name = ; String[] commands = ; String[] decorations
		 * = ; String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SignatureDecorator().applyDecoration(name, commands, decorations)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
