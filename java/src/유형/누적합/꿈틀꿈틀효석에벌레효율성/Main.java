package 유형.누적합.꿈틀꿈틀효석에벌레효율성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static long k;

	private static long[] arr;

	private static long[] dp;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		long temp = arr[1];
		int left = 1;
		int right = 1;
		long max = 0;
		while (right <= n) {
			if (temp < k) {
				dp[right] = max;
				right++;
				if (right <= n) {
					temp += arr[right];
				}
			} else {
				max = Math.max(max, dp[left - 1] + temp - k);
				dp[right] = max;
				temp -= arr[left];
				left++;
			}
		}
		System.out.println(dp[n]);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Long.parseLong(st.nextToken());
			arr = new long[n + 1];
			dp = new long[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
