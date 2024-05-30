package 유형.투포인터.두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 3273.
 * <p>
 * 투포인터
 * </p>
 */
public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			int k = Integer.parseInt(br.readLine());
			int answer = 0;


			int s = 0;
			int e = n - 1;
			while (s < e) {
				int temp = arr[s] + arr[e];
				if (temp == k) {
					answer++;
					e--;
				} else if (temp < k) {
					s++;
				} else {
					e--;
				}
			}
			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
