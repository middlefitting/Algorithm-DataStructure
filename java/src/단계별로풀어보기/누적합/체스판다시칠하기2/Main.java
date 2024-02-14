package 단계별로풀어보기.누적합.체스판다시칠하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] arr1 = new int[n][m];
			int[][] arr2 = new int[n][m];
			int[][] sum1 = new int[n][m];
			int[][] sum2 = new int[n][m];
			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				for (int j = 0; j < m; j++) {
					char c = temp.charAt(j);
					if (((j + i) % 2 == 0 && c == 'B') || ((j + i) % 2 == 1 && c == 'W')) {
						arr1[i][j] = 1;
						arr2[i][j] = 0;
					} else {
						arr1[i][j] = 0;
						arr2[i][j] = 1;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int up = i - 1 >= 0 ? sum1[i - 1][j] : 0;
					int left = j - 1 >= 0 ? sum1[i][j - 1] : 0;
					int side = j - 1 >= 0 && i - 1 >= 0 ? sum1[i - 1][j - 1] : 0;
					sum1[i][j] = up + left + arr1[i][j] - side;

					up = i - 1 >= 0 ? sum2[i - 1][j] : 0;
					left = j - 1 >= 0 ? sum2[i][j - 1] : 0;
					side = j - 1 >= 0 && i - 1 >= 0 ? sum2[i - 1][j - 1] : 0;
					sum2[i][j] = up + left + arr2[i][j] - side;
				}
			}

			int answer = Integer.MAX_VALUE;
			for (int i = k - 1; i < n; i++) {
				for (int j = k - 1; j < m; j++) {
					int left = j - k >= 0 ? sum1[i][j - k] : 0;
					int up = i - k >= 0 ? sum1[i - k][j] : 0;
					int diagonal = j - k >= 0  && i - k >= 0 ? sum1[i - k][j - k] : 0;
					answer = Math.min(answer, sum1[i][j] - left - up + diagonal);
					left = j - k >= 0 ? sum2[i][j - k] : 0;
					up = i - k >= 0 ? sum2[i - k][j] : 0;
					diagonal = j - k >= 0  && i - k >= 0 ? sum2[i - k][j - k] : 0;
					answer = Math.min(answer, sum2[i][j] - left - up + diagonal);
				}
			}

			System.out.println(answer);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
