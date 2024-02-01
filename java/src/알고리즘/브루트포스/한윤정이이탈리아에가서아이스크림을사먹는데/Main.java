package 알고리즘.브루트포스.한윤정이이탈리아에가서아이스크림을사먹는데;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Reader {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private Reader() {
		throw new RuntimeException();
	}

	public static int[] readIntegerArrayLine() {
		try {
			return
				Stream.of(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
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
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				for (int k = j + 1; k <= N; k++) {
					if (!forbidden[i][j] && !forbidden[i][k] && !forbidden[j][k]) {
						answer += 1;
					}
				}
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
