package 랜덤디팬스.실버.배너걸기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 27527.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/04/23
 */
public class Main {
	private static int[] arr;
	private static int n;
	private static int m;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int left = 0;
		int right = m - 1;
		for (int i = 0; i < m; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			max = Math.max(max, map.get(arr[i]));
		}
		while (right < n - 1) {
			map.put(arr[left], map.get(arr[left]) - 1);
			left++;
			right++;
			map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
			max = Math.max(max, map.get(arr[right]));
		}
		int targetCnt = Math.abs(9 * m / 10);
		if (m % 10 != 0) {
			targetCnt++;
		}
		if (max >= targetCnt) {
			System.out.println("YES");

		} else {
			System.out.println("NO");
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
