package 유형.깊이우선탐색.저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	static boolean[] v;
	static int[] cnt;
	static Vector<Integer>[] vec;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			v = new boolean[n + 1];
			cnt = new int[n + 1];
			Arrays.fill(cnt, 1);
			vec = new Vector[n + 1];
			for (int i = 0; i <= n; i++) {
				vec[i] = new Vector<>();
			}

			StringTokenizer st;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				vec[a].add(b);
			}

			for (int i = 1; i <= n; i++) {
				if (!v[i]) {
					ArrayList<Integer> arr = new ArrayList<>();
					arr.add(i);
					dfs(arr, i);
				}
			}



		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void dfs(ArrayList<Integer> arr, int i) {
		v[i] = true;
		for (int child : vec[i]) {
			if (!v[child]) {
				dfs(arr, child);
			}
			cnt[i] += cnt[child];
			cnt[child] += 1;
		}
	}
}



