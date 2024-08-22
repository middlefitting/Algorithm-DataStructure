package 유형.브루트포스.보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Treasure.DTO dto = parse();
		Treasure treasure = new Treasure(dto);
		System.out.println(treasure.getMaxLength());
	}

	private static Treasure.DTO parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char[][] arr = new char[n][m];

			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			return new Treasure.DTO(n, m, arr);
		} catch (IOException e) {
			throw new RuntimeException();
		}

	}

	static class Treasure {
		int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		int n;
		int m;
		char[][] arr;

		public Treasure(DTO dto) {
			this.n = dto.n;
			this.m = dto.m;
			this.arr = dto.arr;
		}

		public int getMaxLength() {
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] != 'L') {
						continue;
					}
					result = Math.max(result, bfs(i, j));
				}
			}
			return result;
		}

		private int bfs(int x, int y) {
			int result = 0;
			boolean[][] v = new boolean[n][m];
			v[x][y] = true;

			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(x, y, 0));
			while (!queue.isEmpty()) {
				Node node = queue.remove();
				result = Math.max(result, node.depth);
				for (int[] mv : mvs) {
					Node newNode = new Node(node.x + mv[0], node.y + mv[1], node.depth + 1);
					if (newNode.x < 0 || newNode.y < 0 || newNode.x >= n || newNode.y >= m) {
						continue;
					}
					if (arr[newNode.x][newNode.y] != 'L') {
						continue;
					}
					if (v[newNode.x][newNode.y]) {
						continue;
					}
					v[newNode.x][newNode.y] = true;
					queue.add(newNode);
				}
			}
			return result;
		}

		static class Node {
			int x;
			int y;
			int depth;

			public Node(int x, int y, int depth) {
				this.x = x;
				this.y = y;
				this.depth = depth;
			}
		}

		static class DTO {
			int n;
			int m;
			char[][] arr;

			public DTO(int n, int m, char[][] arr) {
				this.n = n;
				this.m = m;
				this.arr = arr;
			}
		}

	}
}
