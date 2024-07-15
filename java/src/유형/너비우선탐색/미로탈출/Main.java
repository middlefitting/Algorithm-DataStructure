package 유형.너비우선탐색.미로탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int hx = Integer.parseInt(st.nextToken()) - 1;
			int hy = Integer.parseInt(st.nextToken()) - 1;

			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;

			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			int answer = Integer.MAX_VALUE;
			boolean[][][] v = new boolean[n][m][2];

			Queue<Node> queue = new LinkedList<>();
			v[hx][hy][0] = true;
			queue.add(new Node(hx, hy, 0, 0));
			int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

			while (!queue.isEmpty()) {
				Node node = queue.poll();
				if (node.x == ex && node.y == ey) {
					answer = Math.min(node.depth, answer);
					continue;
				}

				for (int[] mv : mvs) {
					int tx = node.x + mv[0];
					int ty = node.y + mv[1];
					int wall = node.wall;

					if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
						continue;
					}

					if (arr[tx][ty] == 1) {
						if (node.wall == 1) {
							continue;
						} else {
							wall++;
						}
					}

					if (v[tx][ty][wall]) {
						continue;
					}

					v[tx][ty][wall] = true;
					queue.add(new Node(tx, ty, wall, node.depth + 1));
				}
			}

			if (answer == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(answer);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node {
		int x;
		int y;

		int wall;
		int depth;

		public Node(int x, int y, int wall, int depth) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.depth = depth;
		}
	}
}
