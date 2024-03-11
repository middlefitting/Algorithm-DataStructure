package 유형.누적합.귀찮아;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Main {

	private static int n;
	private static long[] nums;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		long answer = 0L;
		HashMap<Long, Long> map = new HashMap<>();
		HashSet<Long> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(nums[i]);
			map.put(nums[i], map.getOrDefault(nums[i], 0L) + 1L);
		}
		Long[] setNums = set.toArray(new Long[0]);
		for (int i = 0; i < set.size(); i++) {
			for (int j = i; j < set.size(); j++) {
				if (i == j) {
					answer += setNums[i] * setNums[j] * (map.get(setNums[i]) - 1) * map.get(setNums[i]) / 2;
				} else {
					answer += setNums[i] * setNums[j] * map.get(setNums[i]) * map.get(setNums[j]);
				}
			}
		}
		System.out.println(answer);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
