package 유형.깊이우선탐색.현수막;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

	static int[][] arr;
	static int n;
	static int m;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arr = new int[n][m];

			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			int cnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int result = dfs(i, j);
					if (result > 0) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int dfs(int i, int j) {
		int result = arr[i][j];
		if (arr[i][j] == 0) {
			return result;
		}
		arr[i][j] = 0;

		for (int[] mv : mvs) {
			int ti = i + mv[0];
			int tj = j + mv[1];
			if (ti < 0 || ti >= n || tj < 0 || tj >= m) {
				continue;
			}
			result += dfs(ti, tj);
		}
		return result;
	}
}
