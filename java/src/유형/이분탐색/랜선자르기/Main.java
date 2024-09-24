package 유형.이분탐색.랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(br.readLine());
			}

			long result = 0;
			long s = 1;
			long e = Arrays.stream(arr).max().orElse(0L);

			while (s <= e) {
				long m = (s + e) / 2;
				int cnt = 0;
				for (long element : arr) {
					cnt += element / m;
				}
				if (cnt >= k) {
					result = Math.max(result, m);
					s = m + 1;
				} else {
					e = m - 1;
				}
			}


			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
