package 유형.깊이우선탐색.회사문화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;

	static int[] parent;

	static int[] score;

	static int[] dp;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			dp = new int[n + 1];
			Arrays.fill(dp, -1);
			parent = new int[n + 1];
			score = new int[n + 1];

			int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < n; i++) {
				parent[i + 1] = temp[i];
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				score[a] += c;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= n; i++) {
				sb.append(dfs(i)).append(" ");
			}

			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int dfs(int x) {
		if (parent[x] == -1) {
			return score[x];
		}
		if (dp[x] == -1) {
			dp[x] = score[x] + dfs(parent[x]);
		}
		return dp[x];
	}
}
