package 유형.dp.내리막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int[] dp;

	static int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			dp = new int[n * m + 1];
			Arrays.fill(dp, -1);
			for (int i = 0; i < n; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			System.out.println(dfs(0, 0));

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int dfs(int i, int j) {
		if (i == n - 1 && j == m - 1) {
			return 1;
		}
		int temp = i * m + j;
		if (dp[temp] != -1) {
			return dp[temp];
		}
		int result = 0;
		for (int[] mv : mvs) {
			int tx = mv[0] + i;
			int ty = mv[1] + j;
			if (tx < 0 || ty < 0 || tx >= n || ty >= m || map[tx][ty] >= map[i][j]) {
				continue;
			}
			result += dfs(tx, ty);
		}
		dp[temp] = result;
		return result;
	}
}

//
// public class Hello {
// 	static int n;
// 	static int m;
// 	static int[][] map;
// 	static int[][] dp;
//
// 	static int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//
// 	public static void main(String[] args) {
// 		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
// 			n = Integer.parseInt(st.nextToken());
// 			m = Integer.parseInt(st.nextToken());
// 			map = new int[n][m];
// 			dp = new int[n * m + 1][4];
// 			for (int i = 0; i < n * m + 1; i++) {
// 				Arrays.fill(dp[i], -1);
// 			}
// 			for (int i = 0; i < n; i++) {
// 				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
// 			}
//
// 			System.out.println(dfs(0, 0));
//
// 		} catch (IOException e) {
// 			throw new RuntimeException();
// 		}
// 	}
//
// 	private static int dfs(int i, int j) {
// 		if (i == n - 1 && j == m - 1) {
// 			return 1;
// 		}
// 		int result = 0;
// 		for (int k = 0; k < 4; k++) {
// 			int[] mv = mvs[k];
// 			int tx = mv[0] + i;
// 			int ty = mv[1] + j;
// 			int temp = i * m + j;
// 			if (tx < 0 || ty < 0 || tx >= n || ty >= m || map[tx][ty] >= map[i][j]) {
// 				continue;
// 			}
// 			if (dp[temp][k] == -1) {
// 				dp[temp][k] = dfs(tx, ty);
// 			}
// 			result += dp[temp][k];
// 		}
// 		return result;
// 	}
// }
