package 유형.투포인터.과일탕후루;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> fruits = new HashMap();

			int result = 1;
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int s = 0;
			int e = 0;

			fruits.put(arr[0], 1);

			while (e < n - 1) {
				e++;
				fruits.put(arr[e], fruits.getOrDefault(arr[e], 0) + 1);
				// 2 이하일때까지 s 더한다
				while (true) {
					int cnt = 0;
					for (int i = 1; i <= 9; i++) {
						if (fruits.getOrDefault(i, 0) > 0) {
							cnt++;
						}
					}
					if (cnt > 2) {
						fruits.put(arr[s], fruits.get(arr[s]) - 1);
						s++;
					} else {
						break;
					}
				}
				result = Math.max(result, e - s + 1);
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
