package 유형.dfs.양한마리양두마리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] arr;
	static int result;
	static int n;
	static int m;

	static int[][] mvs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int k = Integer.parseInt(br.readLine());

			for (int t = 0; t < k; t++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());

				arr = new char[n][m];

				for (int i = 0; i < n; i++) {
					arr[i] = br.readLine().toCharArray();
				}

				result = 0;

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						int temp = dfs(i, j);
						if (temp > 0) {
							result++;
						}
					}
				}
				System.out.println(result);
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int dfs(int i, int j) {
		int temp = 1;
		if (arr[i][j] != '#') {
			return 0;
		}

		arr[i][j] = '.';

		for (int[] mv : mvs) {
			int ti = mv[0] + i;
			int tj = mv[1] + j;
			if (ti < 0 || tj < 0 || ti >= n || tj >= m) {
				continue;
			}
			temp += dfs(ti, tj);
		}

		return temp;
	}
}
