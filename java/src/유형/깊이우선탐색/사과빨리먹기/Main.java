package 유형.깊이우선탐색.사과빨리먹기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[][] arr = new int[5][5];
	private static boolean[][] v = new boolean[5][5];
	private static int[][] mv = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			for (int i = 0; i < 5; i++) {
				int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for (int j = 0; j < 5; j++) {
					arr[i][j] = temp[j];
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			v[x][y] = true;
			dfs(x, y, 0, 0);
			if (answer == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(answer);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void dfs(int x, int y, int depth, int result) {
		if (arr[x][y] == 1) {
			result++;
		}
		if (result == 3) {
			answer = Math.min(answer, depth);
			return;
		}
		for (int[] m : mv) {
			int tx = x + m[0];
			int ty = y + m[1];
			if (tx < 0 || ty < 0 || tx >= 5 || ty >= 5 || v[tx][ty]) {
				continue;
			}
			if (v[tx][ty] || arr[tx][ty] == -1) {
				continue;
			}
			v[tx][ty] = true;
			dfs(tx, ty, depth + 1, result);
			v[tx][ty] = false;
		}
	}
}
