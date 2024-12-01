package 유형.그리디.카우버거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int minCnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).min().orElse(0);
			Integer[] burgers = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
			Integer[] sides = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
			Integer[] beverages = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);


			Arrays.sort(burgers, Collections.reverseOrder());
			Arrays.sort(sides, Collections.reverseOrder());
			Arrays.sort(beverages, Collections.reverseOrder());

			int result1 = 0;
			int result2 = 0;

			int idx = 0;
			while (true) {

				if (burgers.length <= idx && sides.length <= idx && beverages.length <= idx) {
					break;
				}

				if (burgers.length > idx && sides.length > idx && beverages.length > idx) {
					int temp = burgers[idx] + sides[idx] + beverages[idx];
					result1 += temp;
					result2 += (temp / 10) * 9;
				} else {
					if (burgers.length > idx) {
						result1 += burgers[idx];
						result2 += burgers[idx];
					}

					if (sides.length > idx) {
						result1 += sides[idx];
						result2 += sides[idx];
					}

					if (beverages.length > idx) {
						result1 += beverages[idx];
						result2 += beverages[idx];
					}
				}

				idx++;
			}

			System.out.println(result1);
			System.out.println(result2);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
