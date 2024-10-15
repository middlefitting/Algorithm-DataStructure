package 유형.다이나믹프로그래밍.거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n + 1];
			Arrays.fill(arr, Integer.MAX_VALUE);
			if (n >= 2) {
				arr[2] = 1;
			}
			if (n >= 4) {
				arr[4] = 2;
			}
			if (n >= 5) {
				arr[5] = 1;
			}
			for (int i = 6; i <= n; i++) {
				arr[i] = Math.min(arr[i - 2], arr[i - 5]);
				if (arr[i] != Integer.MAX_VALUE) {
					arr[i]++;
				}
			}

			if (arr[n] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(arr[n]);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
