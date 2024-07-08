package 유형.깊이우선탐색.트리와쿼리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int NOT_VISIT = -1;
	private static ArrayList<LinkedList<Integer>> vec = new ArrayList<>(100002);
	private static int[] dp;
	private static int[] dist;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			dist = new int[n + 1];
			dp = new int[n + 1];
			Arrays.fill(dp, NOT_VISIT);
			for (int i = 0; i < n + 1; i++) {
				vec.add(new LinkedList<>());
			}

			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				vec.get(a).add(b);
				vec.get(b).add(a);
			}

			bfs(r);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < q; i++) {
				sb.append(dfs(Integer.parseInt(br.readLine()))).append("\n");
			}
			System.out.println(sb);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void bfs(int root) {
		Queue<Node> queue = new LinkedList<>();
		boolean[] v = new boolean[vec.size()];

		queue.add(new Node(root, 0));
		v[root] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			dist[node.x] = node.depth;

			for (int y : vec.get(node.x)) {
				if (!v[y]) {
					v[y] = true;
					queue.add(new Node(y, node.depth + 1));
				}
			}
		}
	}

	private static int dfs(int x) {

		if (dp[x] != NOT_VISIT) {
			return dp[x];
		}

		int result = 1;
		for (int i : vec.get(x)) {
			if (dist[x] < dist[i]) {
				result += dfs(i);
			}
		}
		dp[x] = result;
		return result;
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
