package 단계별로풀어보기.그래프와순회.알고리즘수업깊이우선탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	private static int[] result;
	private static int temp = 1;
	private static int[][] vec;

	private static void dfs(int x) {
		result[x] = temp++;
		for (int i : vec[x]) {
			if (result[i] == 0) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			result = new int[n + 1];
			ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
			IntStream.rangeClosed(0, n).forEach((i) -> arr.add(new ArrayList<>()));
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr.get(a).add(b);
				arr.get(b).add(a);
			}
			vec = new int[n + 1][];
			IntStream.rangeClosed(0, n).forEach((i) -> {
				vec[i] = arr.get(i).stream().sorted().mapToInt(Integer::intValue).toArray();
			});
			dfs(r);
			StringBuffer sb = new StringBuffer();
			for (int i = 1; i <= n; i++) {
				sb.append(result[i]).append("\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
