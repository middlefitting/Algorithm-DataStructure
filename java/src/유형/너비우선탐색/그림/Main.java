package 유형.너비우선탐색.그림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;
	private static int[][] arr;
	private static boolean[][] v;
	private static int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	private static int cnt = 0;
	private static int answer = 0;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			v = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					bfs(i, j);
				}
			}
			System.out.println(cnt);
			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void bfs(int i, int j) {
		if (v[i][j] || arr[i][j] == 0) {
			return;
		}
		v[i][j] = true;
		cnt++;
		int result = 1;

		Deque<Position> deque = new ArrayDeque<>();
		deque.addLast(new Position(i, j));
		while (!deque.isEmpty()) {
			Position pos = deque.removeFirst();
			for (int[] mv : mvs) {
				int tx = mv[0] + pos.x;
				int ty = mv[1] + pos.y;
				if (tx < 0 || ty < 0 || tx >= n || ty >= m || arr[tx][ty] == 0 || v[tx][ty]) {
					continue;
				}
				v[tx][ty] = true;
				result++;
				deque.add(new Position(tx, ty));
			}
		}

		answer = Math.max(answer, result);
	}

	private static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
