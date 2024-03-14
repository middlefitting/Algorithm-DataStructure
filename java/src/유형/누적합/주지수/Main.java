package 유형.누적합.주지수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] sums = new int[n + 1][m + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= m; j++) {
					sums[i][j] = Integer.parseInt(st.nextToken()) + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
				}
			}

			int k = Integer.parseInt(br.readLine());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				sb.append(sums[c][d] - sums[a - 1][d] - sums[c][b - 1] + sums[a - 1][b - 1]).append("\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
