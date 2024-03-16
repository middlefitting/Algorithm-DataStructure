package 유형.누적합.폭탄던지는태영이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static long[][] arr;
	private static long[][] sums;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		long[][] bombs = new long[n + 1][n + 1];
		int size = m / 2;
		for (int i = 1; i <= n - size; i++) {
			for (int j = 1; j <= n - size; j++) {
				int sx = Math.max(0, i - size - 1);
				int sy = Math.max(0, j - size - 1);
				int ex = i + size;
				int ey = j + size;
				sums[ex][ey] = sums[ex - 1][ey] + sums[ex][ey - 1] - sums[ex - 1][ey - 1];
				long bombCnt = sums[ex][ey] - sums[sx][ey] - sums[ex][sy] + sums[sx][sy];
				long targetCnt = arr[i][j] * -1L - bombCnt;
				bombs[ex][ey] += targetCnt;
				sums[ex][ey] += targetCnt;
			}
		}
		StringBuffer answer = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				answer.append(bombs[i][j]).append(" ");
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new long[n + 1][n + 1];
			sums = new long[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Long.parseLong(st.nextToken());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
