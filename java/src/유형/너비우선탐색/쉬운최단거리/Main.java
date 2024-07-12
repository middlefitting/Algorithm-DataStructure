package 유형.너비우선탐색.쉬운최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			// parse
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][m];
			int[][] result = new int[n][m];
			boolean[][] v = new boolean[n][m];
			Queue<Node> queue = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for (int j = 0; j < m; j++) {
					result[i][j] = arr[i][j] == 0 ? 0 : -1;
					if (arr[i][j] == 2) {
						queue.add(new Node(i, j, 0));
						v[i][j] = true;
					}
				}
			}

			// bfs
			int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
			while (!queue.isEmpty()) {
				Node x = queue.remove();
				result[x.i][x.j] = x.distance;
				for (int[] mv : mvs) {
					Node y = new Node(x.i + mv[0], x.j + mv[1], x.distance + 1);
					if (y.i < 0 || y.i >= n || y.j < 0 || y.j >= m || v[y.i][y.j] || arr[y.i][y.j] == 0) {
						continue;
					}
					v[y.i][y.j] = true;
					queue.add(y);
				}
			}

			// calc
			String answer = Arrays.stream(result)
				.map((row) -> Arrays.stream(row)
					.mapToObj(String::valueOf)
					.collect(Collectors.joining(" ")))
				.collect(Collectors.joining("\n"));

			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node {
		int i;
		int j;
		int distance;

		public Node(int i, int j, int distance) {
			this.i = i;
			this.j = j;
			this.distance = distance;
		}
	}
}

