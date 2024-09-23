package 유형.그리디.보물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
			int[] arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

			int result = 0;
			for (int i = 0; i < n; i++) {
				result += arrA[i] * arrB[i];
			}
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
