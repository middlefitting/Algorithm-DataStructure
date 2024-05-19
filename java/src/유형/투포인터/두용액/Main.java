package 유형.투포인터.두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(arr);
			int l = 0;
			int r = n - 1;
			int[] answer = {0, n - 1};
			int temp = Math.abs(arr[l] + arr[r]);
			while (r > l + 1) {
				if (arr[l] + arr[r] < 0) {
					l++;
				} else {
					r--;
				}
				if (Math.abs(arr[l] + arr[r]) < temp) {
					temp = Math.abs(arr[l] + arr[r]);
					answer[0] = l;
					answer[1] = r;
				}
			}
			System.out.println(arr[answer[0]] + " " + arr[answer[1]]);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
