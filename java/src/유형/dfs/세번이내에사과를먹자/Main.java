package 유형.dfs.세번이내에사과를먹자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int result = 0;
	private static int mvs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static int[][] map = new int[5][5];
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;

			for (int i = 0; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 5; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			dfs(n, m, 0, 0);

			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void dfs(int n, int m, int depth, int cnt) {
		int temp = map[n][m];
		if (map[n][m] == -1 || depth > 3) {
			return;
		}
		if (map[n][m] == 1) {
			cnt++;
		}
		map[n][m] = -1;

		if (cnt == 2) {
			result = 1;
		}

		for (int[] mv : mvs) {
			int tn = mv[0] + n;
			int tm = mv[1] + m;
			if (tn < 0 || tn >= 5 || tm < 0 || tm >= 5) {
				continue;
			}
			dfs(tn, tm, depth + 1, cnt);
		}

		map[n][m] = temp;
	}
}
