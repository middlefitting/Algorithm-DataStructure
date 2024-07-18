package 유형.너비우선탐색.숨바꼭질2;

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

			int[] v = new int[100001];
			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(n, 0));
			Arrays.fill(v, Integer.MAX_VALUE);
			v[n] = 0;
			int answer = Integer.MAX_VALUE;
			int cnt = 0;

			while (!queue.isEmpty()) {
				Node node = queue.poll();
				if (node.x == m) {
					answer = Math.min(answer, node.depth);
					if (answer == node.depth) {
						cnt++;
					}
					continue;
				}

				if (node.x - 1 >= 0 && v[node.x - 1] >= node.depth + 1) {
					queue.add(new Node(node.x - 1, node.depth + 1));
					v[node.x - 1] = node.depth + 1;
				}

				if (node.x + 1 >= 0 && node.x + 1 <= 100000 && v[node.x + 1] >= node.depth + 1) {
					queue.add(new Node(node.x + 1, node.depth + 1));
					v[node.x + 1] = node.depth + 1;
				}

				if (node.x * 2 <= 100000 && v[node.x * 2] >= node.depth + 1) {
					queue.add(new Node(node.x * 2, node.depth + 1));
					v[node.x * 2] = node.depth + 1;
				}
			}

			System.out.println(answer);
			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node {
		int x;
		int depth;

		public Node(int x, int depth) {
			this.x = x;
			this.depth = depth;
		}
	}
}
