package 유형.투포인터.합이0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			HashMap<Long, Long> dict = new HashMap<>(10000);

			for (long i : arr) {
				dict.put(i, dict.getOrDefault(i, 0L) + 1);
			}

			int result = 0;
			long a;
			long b;
			long target;
			long size;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					a = arr[i];
					b = arr[j];
					target = (a + b) * -1;
					size = dict.getOrDefault(target, 0L);
					if (a == target) {
						size--;
					}
					if (b == target) {
						size--;
					}
					result += size;
				}
			}

			System.out.println(result / 3);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
