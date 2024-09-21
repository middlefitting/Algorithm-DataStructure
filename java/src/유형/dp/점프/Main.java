package 유형.dp.점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	static final int NOT_VISIT = -1;
	static int[][] map;
	static long[][] dp;
	static LinkedList<Node>[][] possible;

	static int n;

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			possible = new LinkedList[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					possible[i][j] = new LinkedList<>();
				}
			}

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			int[][] mvs = {{1, 0}, {0, 1}};
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int[] mv : mvs) {
						int ti = mv[0] * map[i][j] + i;
						int tj = mv[1] * map[i][j] + j;
						if (i == ti && j == tj) {
							continue;
						}

						if (ti >= n || tj >= n || ti < 0 || tj < 0) {
							continue;
						}
						possible[ti][tj].add(new Node(i, j));
					}
				}
			}

			dp = new long[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(dp[i], NOT_VISIT);
			}
			dp[0][0] = 1;

			System.out.println(dfs(n - 1, n - 1));

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static long dfs(int i, int j) {
		if (dp[i][j] != NOT_VISIT) {
			return dp[i][j];
		}

		dp[i][j] = 0;

		for (Node pre : possible[i][j]) {
			dp[i][j] += dfs(pre.i, pre.j);
		}

		return dp[i][j];
	}
}
