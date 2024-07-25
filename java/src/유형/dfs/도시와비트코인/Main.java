package 유형.dfs.도시와비트코인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] v;
	static int[][] map;
	static boolean result = false;
	static int n;
	static int m;

	static int[][] mvs = {{1, 0}, {0, 1}};

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			map = new int[n][m];

			for (int i = 0; i < n; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			v = new boolean[n][m];

			dfs(0, 0);

			if (result) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} catch (IOException e) {

			throw new RuntimeException();
		}
	}

	private static void dfs(int x, int y) {

		v[x][y] = true;

		if (x == n - 1 && y == m - 1) {
			result = true;
			return;
		}

		for (int[] mv : mvs) {
			int tx = x + mv[0];
			int ty = y + mv[1];

			if (tx >= n || ty >= m) {
				continue;
			}

			if (map[tx][ty] != 1) {
				continue;
			}

			if (v[tx][ty]) {
				continue;
			}

			dfs(tx, ty);
		}
	}
}
