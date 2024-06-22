package 유형.깊이우선탐색.양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static boolean[][] v;
	private static char[][] arr;
	private static int[][] mvs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			v = new boolean[n][m];
			arr = new char[n][m];

			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					arr[i][j] = s.charAt(j);
				}
			}

			Result result = new Result();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!v[i][j] && arr[i][j] != '#') {
						result.calc(bfs(new Direction(i, j)));
					}
				}
			}

			System.out.println(result.lamb + " " + result.wolf);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static Result bfs(Direction start) {
		Result result = new Result();
		v[start.i][start.j] = true;

		result.calc(start);

		Queue<Direction> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Direction x = queue.poll();
			for (int[] mv : mvs) {
				Direction y = new Direction(x.i + mv[0], x.j + mv[1]);
				if (y.i < 0 || y.i >= n || y.j < 0 || y.j >= m) {
					continue;
				}
				if (v[y.i][y.j] || arr[y.i][y.j] == '#') {
					continue;
				}
				v[y.i][y.j] = true;
				result.calc(y);
				queue.add(y);
			}
		}

		result.fight();
		return result;
	}

	private static class Direction {
		final int i;
		final int j;

		Direction(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static class Result {
		int lamb;
		int wolf;

		private void calc(Direction d) {
			if (arr[d.i][d.j] == 'o') {
				lamb += 1;
			} else if (arr[d.i][d.j] == 'v') {
				wolf += 1;
			}
		}

		private void calc(Result result) {
			lamb += result.lamb;
			wolf += result.wolf;
		}

		public void fight() {
			if (lamb > wolf) {
				wolf = 0;
			} else {
				lamb = 0;
			}
		}
	}
}
