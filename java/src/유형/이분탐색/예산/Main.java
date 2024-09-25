package 유형.이분탐색.예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long k = Long.parseLong(br.readLine());

			long result = 0;


			long s = 1;
			long e = Arrays.stream(arr).max().orElse(0L);

			while (s <= e) {
				long m = (s + e) / 2;
				long amount = 0;
				for (long needs : arr) {
					if (needs > m) {
						amount += m;
					} else {
						amount += needs;
					}
				}
				if (amount > k) {
					e = m - 1;
				} else {
					result = Math.max(result, m);
					s = m + 1;
				}
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
