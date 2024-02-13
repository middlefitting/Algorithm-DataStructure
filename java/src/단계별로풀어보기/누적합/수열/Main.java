package 단계별로풀어보기.누적합.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] nums =
				Stream.of(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			int[] sums = new int[n];
			sums[0] = nums[0];
			for (int i = 1; i < n; i++) {
				sums[i] = nums[i] + sums[i - 1];
			}
			int result = Integer.MIN_VALUE;
			for (int i = k - 1; i < n; i++) {
				int j = i - k;
				if (i != j && j >= 0) {
					result = Math.max(result, sums[i] - sums[j]);
				} else {
					result = Math.max(result, sums[i]);
				}
			}
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
