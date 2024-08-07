package 유형.dfs.영상처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] resultArr;
	static int result;
	static int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	static int n;
	static int m;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][m * 3];

			result = 0;


			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			int k = Integer.parseInt(br.readLine()) * 3;

			resultArr = new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j * 3] + arr[i][j * 3 + 1] + arr[i][j * 3 + 2] >= k) {
						resultArr[i][j] = 1;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (dfs(i, j) > 0) {
						result++;
					}
				}
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int dfs(int i, int j) {
		int temp = 0;
		if (resultArr[i][j] != 1) {
			return temp;
		}
		resultArr[i][j] = 0;
		temp++;
		for (int[] mv : mvs) {
			int ti = mv[0] + i;
			int tj = mv[1] + j;
			if (ti < 0 || tj < 0 || ti >= n || tj >= m || resultArr[ti][tj] != 1) {
				continue;
			}
			temp += dfs(ti, tj);
		}

		return temp;
	}
}
