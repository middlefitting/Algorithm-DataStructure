package 유형.너비우선탐색.돌다리;

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
		boolean[] v = new boolean[100001];
		queue.add(new Node(data.s, 0));
		v[data.s] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.x == data.e) {
				System.out.println(node.depth);
				break;
			}
			int[] txs = {node.x - 1, node.x + 1, node.x * data.a, node.x * data.b, node.x + data.a, node.x - data.a,
				node.x + data.b, node.x - data.b};
			for (int tx : txs) {
				if (tx < 0 || tx > 100000) {
					continue;
				}
				if (v[tx]) {
					continue;
				}
				v[tx] = true;
				queue.add(new Node(tx, node.depth + 1));
			}
		}
	}

	private static Data parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			return new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
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
		int s;
		int e;

		public Data(int a, int b, int s, int e) {
			this.a = a;
			this.b = b;
			this.s = s;
			this.e = e;
		}
	}
}
