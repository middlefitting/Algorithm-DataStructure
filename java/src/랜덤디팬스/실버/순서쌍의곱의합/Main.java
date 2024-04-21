package 랜덤디팬스.실버.순서쌍의곱의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 13900.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/04/21
 */
public class Main  {
	private static int n;
	private static long[] arr;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		long result = 0;
		long sum = Arrays.stream(arr).sum();
		for (int i = 0; i < n; i++) {
			result += (sum - arr[i]) * arr[i];
		}
		System.out.println(result / 2);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
