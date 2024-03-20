package 유형.누적합.꿀따기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int arr[];
	private static int sums[];

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		int answer = 0;

		int x1;
		int x2;
		int y;
		// 벌, 벌, 꿀통
		x1 = 1;
		y = n;
		for (int i = 2; i < n; i++) {
			x2 = i;
			int temp = 2 * sums[y] - arr[x1] - arr[x2] - sums[x2];
			answer = Math.max(temp, answer);
		}

		// 꿀통, 벌, 벌
		x1 = n;
		y = 1;
		for (int i = 2; i < n; i++) {
			x2 = i;
			int temp = sums[x1 - 1] - arr[x2] + sums[x2 - 1];
			answer = Math.max(temp, answer);
		}

		// 벌, 꿀통, 벌
		x1 = 1;
		x2 = n;
		for (int i = 2; i < n; i++) {
			y = i;
			int temp = sums[y] - sums[1] + sums[n - 1] - sums[y - 1];
			answer = Math.max(temp, answer);
		}
		System.out.println(answer);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			sums = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				int x = Integer.parseInt(st.nextToken());
				arr[i] = x;
				sums[i] = sums[i - 1] + x;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
