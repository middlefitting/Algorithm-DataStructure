package 유형.dfs.작업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			LinkedList<Integer>[] arr = new LinkedList[n + 1];

			for (int i = 0; i <= n; i++) {
				arr[i] = new LinkedList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[b].add(a);
			}

			int job = Integer.parseInt(br.readLine());

			System.out.println(dfs(job, arr, new HashSet<>()).size() - 1);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static HashSet<Integer> dfs(int x, LinkedList<Integer>[] childs, HashSet<Integer> result) {

		result.add(x);

		for (int child : childs[x]) {
			if (!result.contains(child)) {

				dfs(child, childs, result);
			}
		}

		return result;
	}
}
