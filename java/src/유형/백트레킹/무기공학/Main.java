package 유형.백트레킹.무기공학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static int[][] arr;
	private static boolean[][] v;
	private static int answer = 0;
	private static int[][][] moves = {{{0, 0}, {0, 1}, {1, 1}}, {{0, 0}, {1, 0}, {1, -1}}, {{0, 0}, {1, 0}, {1, 1}}, {{1, 0}, {0, 0}, {0, 1}}};

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int depth, int result) {
		if (depth == n * m) {
			answer = Math.max(result, answer);
			return;
		}
		// 4가지
		int x = depth / m;
		int y = depth % m;
		for (int[][] move : moves) {
			boolean flag = true;
			for (int[] mv_info : move) {
				int tx = x + mv_info[0];
				int ty = y + mv_info[1];
				if (tx < 0 || tx >= n || ty <0 || ty >= m || v[tx][ty]) {
					flag = false;
				}
			}
			if (flag) {
				int sumValue = arr[move[1][0] + x][move[1][1] + y];
				for (int[] mv_info : move) {
					int tx = x + mv_info[0];
					int ty = y + mv_info[1];
					sumValue += arr[tx][ty];
					v[tx][ty] = true;
				}
				dfs(depth + 1, result + sumValue);
				for (int[] mv_info : move) {
					int tx = x + mv_info[0];
					int ty = y + mv_info[1];
					v[tx][ty] = false;
				}
			}
		}
		dfs(depth + 1, result);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			v = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
