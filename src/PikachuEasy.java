public class PikachuEasy {

	public String check(String word) {
		char[] charArray = word.toCharArray();

		int point = 0;
		while (point < charArray.length) {
			if (charArray[point] == 'p' && charArray[point + 1] == 'i') {
				point += 2;
			}
			else if (charArray[point] == 'k' && charArray[point + 1] == 'a') {
				point+=2;
			}
			else if (charArray[point] == 'c' && charArray[point + 1] == 'h' &&  charArray[point + 2] == 'u') {
				point+=3;
			}
			else {
				return "NO";
			}
		}
		return "YES";
	}

	public String check2(String word) {
		String[] list = { "pi", "ka", "chu" };
		while (word.length() > 0) {
			boolean hit = false;
			for (String str : list) {
				if (word.startsWith(str)) {
					word = word.substring(str.length());
					hit = true;
				}
			}
			if (hit == false) {
				return "NO";
			}
		}

		return "YES";
	}

}



// Powered by FileEdit
// Powered by moj 4.17 [modified TZTester]
// Powered by CodeProcessor
