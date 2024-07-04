package 유형.너비우선탐색.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][m];
			boolean[][] v = new boolean[n][m];
			int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			Queue<Node> queue = initQueue(arr);

			int time = 0;
			int left = 0;
			int result = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1) {
						left++;
					}
				}
			}

			while (left > 0) {
				Queue<Node> nextQueue = new LinkedList<>();
				result = left;
				time++;

				while (!queue.isEmpty()) {
					Node x = queue.poll();
					for (int[] mv : mvs) {
						Node y = new Node(x.x + mv[0], x.y + mv[1]);
						if (y.x < 0 || y.y < 0 || y.x >= n || y.y >= m || v[y.x][y.y]) {
							continue;
						}
						v[y.x][y.y] = true;

						if (arr[y.x][y.y] == 1) {
							left--;
							nextQueue.add(y);
						} else {
							queue.add(y);
						}
					}
				}

				queue = nextQueue;
			}

			System.out.println(time);
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static Queue<Node> initQueue(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;

		Queue<Node> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			if (arr[i][0] == 0) {
				queue.add(new Node(i, 0));
			}

			if (arr[i][m - 1] == 0) {
				queue.add(new Node(i, m -1));
			}
		}

		for (int j = 0; j < m; j++) {
			if (arr[0][j] == 0) {
				queue.add(new Node(0, j));
			}

			if (arr[n - 1][j] == 0) {
				queue.add(new Node(n - 1, j));
			}
		}

		return queue;
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
