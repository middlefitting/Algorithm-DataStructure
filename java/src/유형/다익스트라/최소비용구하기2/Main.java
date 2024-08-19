package 유형.다익스트라.최소비용구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			boolean[] v = new boolean[n + 1];
			int[] dist = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			ArrayList<Integer>[] info = new ArrayList[n + 1];
			ArrayList<Line>[] lines = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				lines[i] = new ArrayList<>();
			}

			StringTokenizer st;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				lines[a].add(new Line(a, b, d));
			}

			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			PriorityQueue<Node> queue = new PriorityQueue<>();
			info[s] = new ArrayList<>();
			info[s].add(s);
			dist[s] = 0;
			queue.add(new Node(s, 0));

			while (!queue.isEmpty()) {
				Node node = queue.poll();
				if (v[node.x]) {
					continue;
				}
				v[node.x] = true;
				for (Line line : lines[node.x]) {
					if (dist[line.e] > node.d + line.d) {
						dist[line.e] = node.d + line.d;
						info[line.e] = new ArrayList<>();
						for (int i : info[line.s]) {
							info[line.e].add(i);
						}
						info[line.e].add(line.e);
						queue.add(new Node(line.e, dist[line.e]));
					}
				}
			}

			System.out.println(dist[e]);
			System.out.println(info[e].size());
			for (int i : info[e]) {
				System.out.print(i + " ");
			}
			System.out.println();

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node implements Comparable<Node> {
		int x;
		int d;

		Node(int x, int d) {
			this.x = x;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(d, o.d);
		}
	}

	static class Line {
		int s;
		int e;
		int d;

		Line(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}
	}
}
