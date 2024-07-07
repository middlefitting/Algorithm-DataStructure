package 유형.너비우선탐색.특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.w3c.dom.Node;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			ArrayList<LinkedList<Integer>> arr = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				arr.add(new LinkedList<>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr.get(a).add(b);
			}

			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(x, 0));

			ArrayList<Integer> result = new ArrayList<>();
			boolean[] v = new boolean[n + 1];
			v[x] = true;
			while (!queue.isEmpty()) {
				Node node = queue.poll();

				if (node.l == k) {
					result.add(node.x);
				}

				if (node.l > k) {
					continue;
				}

				for (int y : arr.get(node.x)) {
					if (v[y]) {
						continue;
					}

					v[y] = true;
					queue.add(new Node(y, node.l + 1));
				}
			}

			if (result.isEmpty()) {
				System.out.println(-1);
			} else {
				System.out.println(result.stream().sorted().map(String::valueOf).collect(Collectors.joining("\n")));
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node {
		int x;
		int l;

		public Node(int x, int l) {
			this.x = x;
			this.l = l;
		}
	}
}
