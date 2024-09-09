package 유형.너비우선탐색.그대그머가되어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		logic(parse());
	}

	private static void logic(Data data) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(data.a, 0));
		data.v[data.a] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.x == data.b) {
				data.result = node.depth;
				break;
			}
			for (int y : data.vec[node.x]) {
				if (data.v[y]) {
					continue;
				}
				data.v[y] = true;
				queue.add(new Node(y, node.depth + 1));
			}
		}

		System.out.println(data.result);
	}

	private static Data parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Data data = new Data(a, b, n, m);
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				data.vec[x].add(y);
				data.vec[y].add(x);
			}
			return data;
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

	static class Data {
		int a;
		int b;
		int n;
		int m;
		LinkedList<Integer>[] vec;
		boolean[] v;
		int result = -1;

		public Data(int a, int b, int n, int m) {
			this.a = a;
			this.b = b;
			this.n = n;
			this.m = m;
			vec = new LinkedList[n + 1];
			v = new boolean[n + 1];
			for (int i = 0; i <= n; i++) {
				vec[i] = new LinkedList<>();
			}
		}
	}
}
