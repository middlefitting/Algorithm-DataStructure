package 알고리즘.easy.조교는;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int result = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] != i + 1) {
					result++;
				}
			}
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
