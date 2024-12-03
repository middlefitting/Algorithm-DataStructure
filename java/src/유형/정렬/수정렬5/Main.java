package 유형.정렬.수정렬5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(arr);

			System.out.print(Arrays.stream(arr).boxed().map(String::valueOf).collect(Collectors.joining("\n")));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
