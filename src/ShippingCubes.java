import java.util.ArrayList;
import java.util.Collections;
//SRM524 Div2 Easy(250)
public class ShippingCubes {
	public int minimalCost(int N) {

		int i = 2;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (N > 1) {

			if (N % i == 0) {
				list.add(i);
				N /= i;
				continue;
			}
			i++;
		}
		list.add(1);
		list.add(1);
		list.add(1);

		Collections.sort(list);

		while (list.size() > 3) {
			int k = 0;
			int v = Integer.MAX_VALUE;
			for (int j = 0; j < 3; j++) {
				if (list.get(j) < v) {
					v = list.get(j);
					k = j;
				}
			}
			list.set(k, list.get(k) * list.get(list.size() - 1));
			list.remove(list.size() - 1);
		}
		System.out.print(list.get(0) + ":" + list.get(1) + ":" + list.get(2));
		int sum = list.get(0) + list.get(1) + list.get(2);
		return sum;
	}
}
