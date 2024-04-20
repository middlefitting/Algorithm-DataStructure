package 랜덤디팬스.실버.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			int target = 0;
			long max = arr[0];
			int idx = 0;
			for (int i = 1; i < n; i++) {
				if (arr[i - 1] > arr[i]) {
					target++;
					idx = i;
				} else {
					max = arr[i];
				}
			}
			if (target >= 2) {
				System.out.println(0);
			} else if (target == 0) {
				System.out.println(n);
			} else if (target == 1) {
				int result = 0;
				if (idx == (n - 1) || arr[idx + 1] >= arr[idx - 1]) {
					result++;
				}
				if ((idx - 1) == 0 || arr[idx - 2] <= arr[idx]) {
					result++;
				}
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
