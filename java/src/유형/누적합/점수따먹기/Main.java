package 유형.누적합.점수따먹기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;

	private static int[][] arr;
	private static int[][] sum;

	private static int answer;

	public static void main(String[] args) {
		parse();
		calcMax();
		System.out.println(answer);
	}

	private static void calcMax() {
		answer = sum[1][1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int il = 0; il < i; il++) {
					for (int jl = 0; jl < j; jl++) {
						answer = Math.max(answer, sum[i][j] - sum[il][j] - sum[i][jl] + sum[il][jl]);
					}
				}
			}
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arr = new int[n + 1][m + 1];
			sum = new int[n + 1][m + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum[i][j] = arr[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
