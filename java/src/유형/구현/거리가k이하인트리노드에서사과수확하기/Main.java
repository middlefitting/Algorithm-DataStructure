package 유형.구현.거리가k이하인트리노드에서사과수확하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int result = 0;
	static int[] apples;
	static LinkedList<Integer>[] arr;


	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			arr = new LinkedList[n];

			for (int i = 0; i < n; i++) {
				arr[i] = new LinkedList<>();
			}

			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}

			apples = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			dfs(0, 0, k);

			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void dfs(int x, int depth, int limit) {
		if (depth > limit) {
			return;
		}

		result += apples[x];

		for (int child : arr[x]) {
			dfs(child, depth + 1, limit);
		}
	}
}
