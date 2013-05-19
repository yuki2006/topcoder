public class MonochromaticBoard {
	public int theMin(String[] data) {
		int result = 0;
		int table[][] = new int[data.length][data[0].length()];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length(); j++) {
				if (data[i].charAt(j) == 'B') {
					table[i][j] = 1;
				} else {
					table[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length(); j++) {

				if (table[i][j] == 1) {
					result++;

					int a = 0, b = 0;
					for (int k = 0; k < data.length; k++) {
						if (table[k][j] == 0) {
							a = 0;
							break;
						}
						if (table[k][j] == 1) {
							a++;

						}
					}
					for (int l = 0; l < data.length; l++) {
						if (table[i][l] == 0) {
							b = 0;
							break;
						}
						if (table[i][l] == 1) {
							b++;
						}
					}
					if (a>b) {
						for (int k = 0; k < data.length; k++) {
							table[k][j] = 2;
						}
					} else {
						for (int l = 0; l < data[i].length(); l++) {
							table[i][l] = 2;
						}
					}

				}
			}
		}
		return result;

	}
}
