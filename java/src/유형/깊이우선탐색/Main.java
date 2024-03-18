package 유형.깊이우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[] dp;
	private static ArrayList<PC>[] vec;
	private static int[] answers;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		int max = 0;
		answers = new int[n + 1];
		boolean[] v;
		for (int i = 1; i <= n; i++) {
			v = new boolean[n + 1];
			v[i] = true;
			Deque<PC> queue = new LinkedList<>();
			queue.add(new PC(i));
			while (!queue.isEmpty()) {
				answers[i]++;
				PC x = queue.removeFirst();
				for (PC pc : vec[x.n]) {
					if (!v[pc.n]) {
						v[pc.n] = true;
						queue.addLast(pc);
					}
				}
			}
			max = Math.max(answers[i], max);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			if (answers[i] == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			dp = new int[n + 1];
			Arrays.fill(dp, -1);
			vec = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				vec[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				vec[b].add(new PC(a));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

class PC {
	int n;

	public PC(int n) {
		this.n = n;
	}
}

