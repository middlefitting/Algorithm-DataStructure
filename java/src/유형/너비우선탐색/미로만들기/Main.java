package 유형.너비우선탐색.미로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int answer = Integer.MAX_VALUE;
			int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

			int[][] arr = new int[n][n];
			int[][] v = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(v[i], Integer.MAX_VALUE);
				arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}

			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(0, 0, 0));
			v[0][0] = 0;

			while (!queue.isEmpty()) {

				Node node = queue.poll();

				if (node.x == n - 1 && node.y == n - 1) {
					answer = Math.min(answer, node.depth);
				}

				for (int[] mv : mvs) {
					int tx = node.x + mv[0];
					int ty = node.y + mv[1];
					if (tx < 0 || tx >= n || ty < 0 || ty >= n) {
						continue;
					}
					int tDepth = (arr[tx][ty] == 1 ? 0 : 1) + node.depth;
					if (tDepth > n * n) {
						continue;
					}
					if (v[tx][ty] <= tDepth) {
						continue;
					}
					v[tx][ty] = tDepth;
					queue.add(new Node(tx, ty, tDepth));
				}
			}

			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node {
		private int x;
		private int y;
		private int depth;

		public Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}


