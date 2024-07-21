package 유형.투포인터.k보다큰구간;

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

			int s = 0;
			int e = 0;
			long cnt = 0;

			long temp = arr[0];

			while (true) {
				if (s > n - 1) {
					break;
				}

				if (s > e) {
					e++;
					temp += arr[e];
				}

				if (temp <= k) {
					while (temp <= k && e < n - 1) {
						e++;
						temp += arr[e];
					}
				}

				if (temp <= k) {
					break;
				}

				cnt += (n - e);
				temp -= arr[s];
				s++;
			}

			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}

