package 유형.이분탐색.나무자르기;

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
			long m = Integer.parseInt(st.nextToken());
			long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

			long s = 0;
			long e = Arrays.stream(arr).max().orElseThrow(RuntimeException::new);
			while (e - s > 1) {
				long mid = (s + e) / 2;
				long sum = 0;
				for (long tree : arr) {
					sum += Math.max(0, tree - mid);
				}
				if (sum >= m) {
					s = mid;
				} else {
					e = mid;
				}
			}
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
