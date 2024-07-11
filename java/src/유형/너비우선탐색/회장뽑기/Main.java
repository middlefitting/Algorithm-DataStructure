package 유형.너비우선탐색.회장뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			ArrayList<LinkedList<Integer>> friends = new ArrayList<>();
			int[] results = new int[n + 1];
			Arrays.fill(results, 0);
			results[0] = 100;

			//parse
			for (int i = 0; i < n + 1; i++) {
				friends.add(new LinkedList<>());
			}

			while (true) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (a == -1 && b == -1) {
					break;
				}
				friends.get(a).add(b);
				friends.get(b).add(a);
			}

			// bfs
			for (int i = 1; i <= n; i++) {
				boolean[] v = new boolean[n + 1];
				v[i] = true;
				Queue<Node> queue = new LinkedList<>();
				queue.add(new Node(i, 0));
				while (!queue.isEmpty()) {
					Node x = queue.remove();
					results[i] = Math.max(x.depth, results[i]);

					for (int y : friends.get(x.x)) {
						if (v[y]) {
							continue;
						}
						v[y] = true;
						queue.add(new Node(y, x.depth + 1));
					}
				}
			}

			// calc
			int score = Arrays.stream(results).min().orElse(100);
			int cnt = (int)Arrays.stream(results).filter((x) -> x == score).count();
			System.out.println(score + " " + cnt);
			System.out.println(IntStream.range(1, n + 1)
				.filter((i) -> results[i] == score)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" ")));

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
