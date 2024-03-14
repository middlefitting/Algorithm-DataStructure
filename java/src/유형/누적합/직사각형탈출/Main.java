package 유형.누적합.직사각형탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static int[][] sums;

	private static int h;
	private static int w;
	private static int sr;
	private static int sc;
	private static int fr;
	private static int fc;
	private static int[][] v;
	private static int answer = -1;

	public static void main(String[] args) {
		parse();
		bfs();
		System.out.println(answer);
	}

	private static void bfs() {
		v[sr][sc] = 1;
		int mv[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		Queue<Direction> queue = new ArrayDeque<>();
		queue.add(new Direction(sr, sc));
		while (!queue.isEmpty()) {
			Direction d = queue.remove();
			for (int i = 0; i < mv.length; i++) {
				int mx = mv[i][0];
				int my = mv[i][1];
				int tx = d.x + mx;
				int ty = d.y + my;
				if (tx < 1 || tx > n - h + 1 || ty < 1 || ty > m - w + 1 || v[tx][ty] != 0) {
					continue;
				}
				if (sums[tx + h - 1][ty + w - 1] - sums[tx - 1][ty + w - 1] - sums[tx + h - 1][ty - 1] + sums[tx - 1][ty - 1] > 0) {
					continue;
				}
				v[tx][ty] = v[d.x][d.y] + 1;
				queue.add(new Direction(tx, ty));
			}
		}
		if (v[fr][fc] > 0) {
			answer = v[fr][fc] - 1;
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sums = new int[n + 1][m + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= m; j++) {
					int num = Integer.parseInt(st.nextToken());
					sums[i][j] = num + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
				}
			}
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			fr = Integer.parseInt(st.nextToken());
			fc = Integer.parseInt(st.nextToken());
			v = new int[n + 1][m + 1];
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

class Direction {
	protected int x;
	protected int y;

	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
