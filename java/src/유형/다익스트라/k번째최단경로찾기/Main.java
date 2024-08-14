package 유형.다익스트라.k번째최단경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			ArrayList<Queue<Long>> costs = new ArrayList<>();
			ArrayList<LinkedList<Line>> lines = new ArrayList<>();

			for (int i = 0; i < n + 1; i++) {
				costs.add(new LinkedList<>());
				lines.add(new LinkedList<>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				long d = Integer.parseInt(st.nextToken());
				lines.get(s).add(new Line(e, d));
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node {
		int x;
		long cost;
	}

	static class Line {
		int e;
		long d;

		Line(int e, long d) {
			this.e = e;
			this.d = d;
		}

	}
}
