package 유형.벨만포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int s;
	static int e;

	static int[] uf;
	static long[] earn;
	static ArrayList<Line> lines = new ArrayList<>();

	public static void main(String[] args) {
		parse();
		bellmanFord();
	}

	private static void bellmanFord() {
		long[] cost;

		cost = new long[n];
		Arrays.fill(cost, Long.MIN_VALUE);
		cost[s] = earn[s];
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (Line line : lines) {
				if (cost[line.s] == Long.MIN_VALUE) {
					continue;
				}
				if (cost[line.e] < cost[line.s] - line.cost + earn[line.e]) {
					cost[line.e] = cost[line.s] - line.cost + earn[line.e];

					if (i == n - 1) {
						queue.add(line.s);
					}
				}
			}
		}

		boolean[] visit = new boolean[n];
		while (!queue.isEmpty()) {
			int s = queue.poll();
			visit[s] = true;

			for (Line mv : lines) {
				if (mv.s == s) {
					if (visit[mv.e]) {
						continue;
					}
					queue.add(mv.e);
				}
			}
		}
		if (visit[e]) {
			cost[e] = Long.MAX_VALUE;
		}


		if (cost[e] == Long.MIN_VALUE) {
			System.out.println("gg");
		} else if (cost[e] == Long.MAX_VALUE) {
			System.out.println("Gee");
		} else {
			System.out.println(cost[e]);
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			uf = new int[n];
			Arrays.fill(uf, -1);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());

				lines.add(new Line(a, b, c));
			}

			earn = new long[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				earn[i] = Long.parseLong(st.nextToken());
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Line {
		int s;
		int e;
		long cost;

		Line(int s, int e, long cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	}
}

