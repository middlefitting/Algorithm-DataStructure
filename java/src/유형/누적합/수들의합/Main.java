package 유형.누적합.수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static long k;
	private static long[] nums;

	private static long[] sums;

	public static void main(String[] args) {
		parse();
		calcAnswer();
	}

	private static void calcAnswer() {
		HashMap<Long, Long> map = new HashMap<>();
		long answer = 0;
		map.put(0L, 1L);
		for (long sum : sums) {
			answer += map.getOrDefault(sum - k, 0L);
			map.put(sum, map.getOrDefault(sum, 0L) + 1);
		}
		System.out.println(answer);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Long.parseLong(st.nextToken());
			nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			sums = new long[n];
			sums[0] = nums[0];
			for (int i = 1; i < n; i++) {
				sums[i] = sums[i - 1] + nums[i];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
