package 유형.dp.rgb거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int[] dp = new int[n];
			Arrays.fill(dp, -1);
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
