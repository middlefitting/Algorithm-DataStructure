package 유형.최소공통조상.가장가까운공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			Node[] nodes;
			StringTokenizer st;
			int a;
			int b;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				nodes = new Node[n + 1];
				for (int j = 1; j <= n; j++) {
					nodes[j] = new Node(j);
				}
				for (int j = 0; j < n - 1; j++) {
					st = new StringTokenizer(br.readLine());
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					nodes[b].parent = nodes[a];
					nodes[a].child.add(nodes[b]);
				}
				for (int j = 1; j <= n; j++) {
					if (nodes[j].parent == null) {
						dfs(nodes[j]);
						break;
					}
				}
				st = new StringTokenizer(br.readLine());
				Node targetA = nodes[Integer.parseInt(st.nextToken())];
				Node targetB = nodes[Integer.parseInt(st.nextToken())];
				Node commonParent = findCommonParent(targetA, targetB);
				sb.append(commonParent.idx).append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static Node findCommonParent(Node a, Node b) {
		while (a.depth != b.depth) {
			if (a.depth > b.depth) {
				a = a.parent;
			} else {
				b = b.parent;
			}
		}
		while (a != b) {
			a = a.parent;
			b = b.parent;
		}
		return a;
	}

	private static void dfs(Node parent) {
		for (Node child : parent.child) {
			child.depth = parent.depth + 1;
			dfs(child);
		}
	}

	static class Node {
		int idx;
		List<Node> child = new ArrayList<>();
		Node parent;
		int depth = 0;

		Node(int idx) {
			this.idx = idx;
		}
	}
}
