package 랜덤디팬스.실버.다중일차함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 26258.
 *
 * <p>
 *
 * </p>
 * @see             :
 * @author          : middlefitting
 * @since           : 2024/04/24
 */
public class Main {

	private static HashMap<Long, Integer> map;
	private static long[] arr;
	private static float[] targets;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		StringBuffer sb = new StringBuffer();
		for (float target : targets) {
			sb.append(binarySearch(target)).append("\n");
		}
		System.out.print(sb);
	}

	private static int binarySearch(float target) {
		int left = 0;
		int right = arr.length - 1;
		int result = right;

		while (true) {
			int mid = (left + right) / 2;
			if (target <= arr[mid]) {
				right = mid;
				result = mid;
			} else {
				left = mid;
			}
			if (right - left <= 1) {
				break;
			}
		}
		return map.get(arr[result]);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			long x;
			long y;
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Long.parseLong(st.nextToken());
			y = Long.parseLong(st.nextToken());
			map = new HashMap<>();
			arr = new long[n];
			arr[0] = x;
			map.put(x, 0);
			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				long nextX = Long.parseLong(st.nextToken());
				long nextY = Long.parseLong(st.nextToken());
				if (y < nextY) {
					map.put(nextX, 1);
				} else if (y > nextY) {
					map.put(nextX, -1);
				} else {
					map.put(nextX, 0);
				}
				x = nextX;
				y = nextY;
				arr[i + 1] = nextX;
			}
			int m = Integer.parseInt(br.readLine());
			targets = new float[m];
			for (int j = 0; j < m; j++) {
				targets[j] = Float.parseFloat(br.readLine());
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
