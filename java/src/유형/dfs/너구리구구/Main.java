package 유형.dfs.너구리구구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Node>[] arr;
	static int n;
	static boolean[] v;
	static long answer = 0;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		v = new boolean[n + 1];
		dfs(1, 0);
		System.out.println(answer);
	}

	private static void dfs(int x, long dist) {
		answer = Math.max(dist, answer);
		v[x] = true;
		for (Node node : arr[x]) {
			if (v[node.next]) {
				continue;
			} else {
				dfs(node.next, node.dist + dist);
			}
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			arr = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				arr[i] = new ArrayList<>();
			}
			for (int i = 0; i < n - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				arr[a].add(new Node(b, d));
				arr[b].add(new Node(a, d));
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node {
		int next;
		long dist;

		public Node(int next, long dist) {
			this.next = next;
			this.dist = dist;
		}
	}
}

