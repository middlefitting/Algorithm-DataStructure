package 알고리즘.easy.헌내기는친구가필요해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static char[][] map;
	private static boolean[][] v;
	private static int answer;
	private static int mv[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static int n;
	private static int m;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 'I') {
						v[i][j] = true;
						dfs(i, j);
					}
				}
			}
			if (answer == 0) {
				System.out.println("TT");
			} else {
				System.out.println(answer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void dfs(int i, int j) {
		for (int[] tm : mv) {
			int tx = i + tm[0];
			int ty = j + tm[1];
			if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
				continue;
			}
			if (v[tx][ty]) {
				continue;
			}
			if (map[tx][ty] == 'X') {
				continue;
			}
			v[tx][ty] = true;
			if (map[tx][ty] == 'P') {
				answer++;
			}
			dfs(tx, ty);
		}
	}
}
