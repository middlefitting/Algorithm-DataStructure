package 유형.dfs.나무탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int result = 0;
	private static boolean[] v;
	private static LinkedList<Integer>[] vec;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		dfs(1, 0);
		if (result % 2 > 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static void dfs(int x, int depth) {
		v[x] = true;
		int childCnt = 0;
		for (int i : vec[x]) {
			if (!v[i]) {
				dfs(i, depth + 1);
				childCnt++;
			}
		}
		if (childCnt == 0) {
			result += depth;
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			vec = new LinkedList[n + 1];
			for (int i = 0; i <= n; i++) {
				vec[i] = new LinkedList<>();
			}
			for (int i = 0; i < n - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				vec[a].add(b);
				vec[b].add(a);
			}
			v = new boolean[n + 1];
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
