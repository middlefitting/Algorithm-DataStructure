package 유형.깊이우선탐색.점프점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int n;
	private static int[] arr;
	private static boolean[] v;
	private static int answer = 1;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			v = new boolean[n];
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int s = Integer.parseInt(br.readLine()) - 1;
			dfs(s);
			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void dfs(int s) {
		int m = arr[s];
		if (s - m >= 0 && !v[s - m]) {
			v[s - m] = true;
			answer++;
			dfs(s - m);
		}
		if (s + m < n && !v[s + m]) {
			v[s + m] = true;
			answer++;
			dfs(s + m);
		}
	}
}
