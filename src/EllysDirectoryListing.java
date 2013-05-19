// Paste me into the FileEdit configuration dialog

public class EllysDirectoryListing {
	public String[] getFiles(String[] files) {
		int i = 0;
		for (; i < files.length; i++) {
			if (files[i].equals(".") || files[i].equals("..")) {
				int j = files.length - 1;
				if (i == j - 1) {
					return files;
				}
				String tmp = files[i];
				files[i] = files[j];
				files[j] = tmp;
				break;
			}
		}
		for (; i < files.length; i++) {
			if (files[i].equals(".") || files[i].equals("..")) {
				for (int j = files.length - 1; j > i; j--) {
					if (!(files[j].equals(".") || files[j].equals(".."))) {
						String tmp = files[i];
						files[i] = files[j];
						files[j] = tmp;
						return files;
					}
				}
			}
		}
		return files;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			EllysDirectoryListingHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				EllysDirectoryListingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class EllysDirectoryListingHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
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
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(String[] expected, String[] result) {
		if (expected.length != result.length)
			return false;
		for (int i = 0; i < expected.length; ++i)
			if (!expected[i].equals(result[i]))
				return false;
		return true;
	}

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i = 0; i < res.length; ++i) {
			if (i > 0)
				ret += ",";
			ret += String.format(" \"%s\"", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, String[] expected, String[] received) {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			String[] files = { "ContestApplet.jnlp", ".", "Image.jpg", "..", "Book.pdf", "Movie.avi" };
			String[] expected__ = { "ContestApplet.jnlp", "Movie.avi", "Image.jpg", "Book.pdf", "..", "." };

			return verifyCase(casenum, expected__, new EllysDirectoryListing().getFiles(files));
		}
		case 1: {
			String[] files = { "Image.jpg", "..", "." };
			String[] expected__ = { "Image.jpg", "..", "." };

			return verifyCase(casenum, expected__, new EllysDirectoryListing().getFiles(files));
		}
		case 2: {
			String[] files = { "..", ".", "Image.jpg" };
			String[] expected__ = { "Image.jpg", ".", ".." };

			return verifyCase(casenum, expected__, new EllysDirectoryListing().getFiles(files));
		}
		case 3: {
			String[] files = { "No", "..", "Zaphod", ".", "Just", "very", "very...", "Improbable" };
			String[] expected__ = { "No", "Improbable", "Zaphod", "very...", "Just", "very", ".", ".." };

			return verifyCase(casenum, expected__, new EllysDirectoryListing().getFiles(files));
		}
		case 4: {
			String[] files = { "www.topcoder.com", "Ever.tried", ".", "Ever.failed", "..", "No", "Matter.", "Try",
					"Again.", "Fail", "Again..", "Fail.Better" };
			String[] expected__ = { "www.topcoder.com", "Ever.tried", "Fail.Better", "Ever.failed", "Again..", "No",
					"Matter.", "Try", "Again.", "Fail", "..", "." };

			return verifyCase(casenum, expected__, new EllysDirectoryListing().getFiles(files));
		}
		case 5: {
			String[] files = { "This", ".", "is", "tricky", "test", ".." };
			String[] expected__ = { "This", "test", "is", "tricky", "..", "." };

			return verifyCase(casenum, expected__, new EllysDirectoryListing().getFiles(files));
		}

		// custom cases

		/*
		 * case 6: {
		 * String[] files = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * EllysDirectoryListing().getFiles(files));
		 * }
		 */
		/*
		 * case 7: {
		 * String[] files = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * EllysDirectoryListing().getFiles(files));
		 * }
		 */
		/*
		 * case 8: {
		 * String[] files = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * EllysDirectoryListing().getFiles(files));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
