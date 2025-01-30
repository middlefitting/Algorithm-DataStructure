package 유형.깊이우선탐색.떡장수와호랑이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	static int n;

	static boolean[][] dp = new boolean[1001][10];

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());

			int[][] arr = new int[n][];

			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			dfs(arr, 0, 0, new LinkedList<>());

			System.out.println(-1);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void dfs(int[][] arr, int depth, int pre, LinkedList<Integer> answers) {
		if (depth == n) {
			for (int i : answers) {
				System.out.println(i);
			}
			System.exit(0);
		}

		boolean flag = true;

		if (dp[depth][pre]) {
			return;
		}

		for (int i : arr[depth]) {
			if (flag) {
				flag = false;
				continue;
			}

			if (pre != i) {
				answers.add(i);
				dfs(arr, depth + 1, i, answers);
				answers.pollLast();
			}

			dp[depth][pre] = true;
		}
	}
}
