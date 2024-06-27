package 유형.투포인터.배열합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n + m];

			st = new StringTokenizer(br.readLine());
			parse(n, 0, arr, st);
			st = new StringTokenizer(br.readLine());
			parse(m, n, arr, st);

			System.out.println(Arrays.stream(arr).sorted().mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void parse(int size, int start, int[] arr, StringTokenizer st) {
		for (int i = start; i < size + start; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
