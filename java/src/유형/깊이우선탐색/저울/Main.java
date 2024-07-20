package 유형.깊이우선탐색.저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dist;

	static int MAX = 10000000;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			dist = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) {
						dist[i][j] = 0;
					} else {
						dist[i][j] = MAX;
					}
				}
			}

			StringTokenizer st;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				dist[a][b] = 1;
			}

			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				int cnt = 0;
				for (int j = 1; j <= n; j++) {
					if (i != j && dist[i][j] == MAX && dist[j][i] == MAX) {
						cnt++;
					}
				}
				System.out.println(cnt);
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

}



