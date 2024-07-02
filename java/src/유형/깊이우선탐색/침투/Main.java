package 유형.깊이우선탐색.침투;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;

	static int[][] arr;

	static boolean[][] v;

	static String result = "NO";

	static int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}

			for (int j = 0; j < m; j++) {
				if (arr[0][j] == 0 && !v[0][j]) {
					dfs(0, j);
				}
			}

			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void dfs(int x, int y) {
		v[x][y] = true;

		if (x == n - 1) {
			result = "YES";
		}

		for (int[] mv : mvs) {
			int tx = mv[0] + x;
			int ty = mv[1] + y;

			if (tx < 0 || ty < 0 || tx >= n || ty >= m || v[tx][ty] || arr[tx][ty] != 0) {
				continue;
			}

			dfs(tx, ty);
		}
	}
}
