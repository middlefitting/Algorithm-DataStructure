package 브루트포스.세친구;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

class Reader {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private Reader() {
		throw new RuntimeException();
	}

	public static int[] readLineToIntegerArray() {
		try {
			return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}

public class Main {
	public static void main(String[] args) {
		int[] arguments = Reader.readLineToIntegerArray();
		int n = arguments[0];
		int m = arguments[1];
		boolean[][] friends = new boolean[n + 1][n + 1];
		int[] friend_cnt = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int[] network = Reader.readLineToIntegerArray();
			int a = network[0];
			int b = network[1];
			friends[a][b] = true;
			friends[b][a] = true;
			friend_cnt[a] += 1;
			friend_cnt[b] += 1;
		}

		int[] possibles = IntStream.rangeClosed(1, n)
			.filter(i -> friend_cnt[i] >= 2)
			.toArray();

		int size = (int) IntStream.rangeClosed(1, n)
			.filter(i -> friend_cnt[i] >= 2)
			.count();


		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			int a = possibles[i];
			for (int j = i + 1; j < size; j++) {
				int b = possibles[j];
				if (!friends[a][b]){
					continue;
				}
				for (int k = j + 1; k < size; k++) {
					int c = possibles[k];
					if (friends[a][c] && friends[b][c]) {
						int cnt = friend_cnt[a] + friend_cnt[b] + friend_cnt[c] - 6;
						answer = Math.min(cnt, answer);
					}
				}
			}
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else  {
			System.out.println(answer);
		}
	}
}
