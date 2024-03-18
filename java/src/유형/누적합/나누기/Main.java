package 유형.누적합.나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			long[] sums = new long[n + 1];
			for (int i = 1; i <= n; i++) {
				sums[i] = Long.parseLong(st.nextToken()) + sums[i - 1];
			}

			long answer = 0;
			if (sums[n] % 4 != 0) {
				answer = 0;
			} else if (sums[n] == 0) {
				long cnt = 0;
				for (int i = 1; i < n; i++) {
					if (sums[i] == 0) {
						cnt++;
					}
				}
				if (cnt >= 3) {
					answer += cnt * (cnt - 1) * (cnt - 2) / 3 / 2;
				}
			} else {
				long[][] dp = new long[4][n + 1];
				dp[0][0] = 1;
				for (int i = 1; i <= n; i++) {
					dp[0][i] = 1;
					for (int j = 1; j <= 3; j++) {
						if (sums[i] == sums[n] / 4 * j) {
							dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
						} else {
							dp[j][i] = dp[j][i - 1];
						}
					}
				}
				answer = dp[3][n];
			}

			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
