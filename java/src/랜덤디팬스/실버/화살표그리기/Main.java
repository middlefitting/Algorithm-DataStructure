package 랜덤디팬스.실버.화살표그리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 15970.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/04/22
 */
public class Main {
	private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		int result = 0;
		for (ArrayList<Integer> arr : map.values()) {
			for (int i : arr) {
				result += findCloseLength(arr, i);
			}
		}
		System.out.println(result);
	}

	private static int findCloseLength(ArrayList<Integer> arr, int target) {
		int result = Integer.MAX_VALUE;
		for (int i : arr) {
			if (i != target) {
				result = Math.min(result, Math.abs(i - target));
			}
		}
		return result;
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				ArrayList<Integer> arr = map.getOrDefault(color, null);
				if (arr == null) {
					map.put(color, new ArrayList<>());
					arr = map.get(color);
				}
				arr.add(num);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
