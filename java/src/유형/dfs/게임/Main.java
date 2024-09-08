package 유형.dfs.게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static final int FINISH = Integer.MAX_VALUE;

	public static void main(String[] args) {
		logic(parse());
	}

	private static void logic(Data data) {
		data.v[0][0] = true;
		dfs(0, 0, 1, data);
		if (data.result == FINISH) {
			System.out.println(-1);
		} else {
			System.out.println(data.result);
		}
	}

	private static void dfs(int x, int y, int depth, Data data) {
		if (data.result == FINISH) {
			return;
		}
		data.result = Math.max(depth, data.result);

		for (int[] mv : mvs) {
			int tx = mv[0] * data.arr[x][y] + x;
			int ty = mv[1] * data.arr[x][y] + y;

			if (tx < 0 || ty < 0 || tx >= data.n || ty >= data.m) {
				continue;
			}
			if (data.arr[tx][ty] == 0) {
				continue;
			}
			if (data.v[tx][ty]) {
				data.result = FINISH;
				return;
			}

			data.v[tx][ty] = true;
			if (data.dp[tx][ty] == -1) {
				dfs(tx, ty, depth + 1, data);
				data.dp[tx][ty] = data.result;
				if (data.dp[tx][ty] == FINISH) {
					return;
				}
				data.dp[tx][ty] -= depth;
			} else {
				if (data.dp[tx][ty] == FINISH) {
					return;
				}
				data.result = Math.max(data.dp[tx][ty] + depth, data.result);
			}

			data.v[tx][ty] = false;
		}
	}

	private static Data parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(""))
					.map((s) -> s.equals("H") ? "0" : s)
					.mapToInt(Integer::parseInt)
					.toArray();
			}
			return new Data(n, m, arr);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Data {
		int n;
		int m;
		int[][] arr;
		boolean[][] v;
		int result;
		int[][] dp;

		public Data(int n, int m, int[][] arr) {
			this.n = n;
			this.m = m;
			this.arr = arr;
			v = new boolean[n][m];
			dp = new int[n][m];
			for (int i = 0; i < n; i++) {
				Arrays.fill(dp[i], -1);
			}
		}
	}
}
