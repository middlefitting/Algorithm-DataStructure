package 브루트포스.한윤정이이탈리아에가서아이스크림을사먹는데;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Reader {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private Reader() {
		throw new RuntimeException();
	}

	// public static ArrayList<Integer> readIntegerArrayLine() {
	// 	try {
	// 		return
	// 			Stream.of(br.readLine().split(" "))
	// 				.map(Integer::parseInt)
	// 				.collect(Collectors.toCollection(ArrayList::new));
	// 	} catch (Exception e) {
	// 		throw new RuntimeException();
	// 	}
	// }

	public static int[] readIntegerArrayLine() {
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] result = new int[st.countTokens()];
			for (int i = 0; i < result.length; i++) {
				result[i] = Integer.parseInt(st.nextToken());
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}

class IceCream {
	boolean[][] forbidden;
	int answer;

	int N;

	public IceCream(Integer N, boolean[][] forbidden) {
		this.N = N;
		this.forbidden = forbidden;
		answer = 0;
		dfs(1, new HashSet<>());
	}

	private void dfs(int idx, HashSet<Integer> select) {
		if (select.size() == 3) {
			answer += 1;
			return;
		}

		for(int i = idx; i <= N; i++) {
			boolean impossible = false;

			for (Integer x : select) {
				if (forbidden[x][i]) {
					impossible = true;
				}
			}

			if (!impossible) {
				select.add(i);
				dfs(i + 1, select);
				select.remove(i);
			}
		}
	}

	public int getAnswer() {
		return answer;
	}

}

public class Main {
	public static void main(String[] args) {
		int[] arguments = Reader.readIntegerArrayLine();
		int N = arguments[0];
		int M = arguments[1];

		boolean[][] forbidden = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int[] nums = Reader.readIntegerArrayLine();
			int a = nums[0];
			int b = nums[1];
			forbidden[a][b] = true;
			forbidden[b][a] = true;
		}

		IceCream iceCream = new IceCream(N, forbidden);
		System.out.println(iceCream.getAnswer());
	}
}
