package 유형.다익스트라.녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = 0;
			StringBuilder sb = new StringBuilder();
			while (true) {
				t++;
				int n = Integer.parseInt(br.readLine());
				if (n == 0) {
					break;
				}
				int[][] arr = new int[n][n];
				for (int i = 0; i < n; i++) {
					arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				}
				int result = dijkstra(n, arr);
				sb.append("Problem " + t + ": " + result + "\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int dijkstra(int n, int[][] arr) {
		int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		int[][] cost = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		cost[0][0] = arr[0][0];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));

		for (int t = 0; t < n * n; t++) {
			Queue<Node> nextQueue = new LinkedList<>();
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				for (int[] mv : mvs) {
					int ti = mv[0] + node.i;
					int tj = mv[1] + node.j;
					if (ti < 0 || tj < 0 || ti >= n || tj >= n || cost[node.i][node.j] == Integer.MAX_VALUE) {
						continue;
					}
					if (cost[ti][tj] > arr[ti][tj] + cost[node.i][node.j]) {
						cost[ti][tj] = arr[ti][tj] + cost[node.i][node.j];
						queue.add(new Node(ti, tj));
					}
				}
			}
			queue = nextQueue;
		}
		return cost[n - 1][n - 1];
	}

	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
