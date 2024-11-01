package 유형.구현.최소최대이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				br.readLine();
				int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				Arrays.sort(arr);
				sb.append(arr[0]).append(" ").append(arr[arr.length - 1]).append("\n");
			}
			System.out.print(sb);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
