package 알고리즘.정렬.선택정렬.알고리즘수업선택정렬2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	private static int n;
	private static int k;
	private static int[] arr;

	private static void parseInput() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static void selectSort() {
		int cnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			int idx = i;
			for (int j = 0; j < i; j++) {
				if (arr[idx] < arr[j]) {
					idx = j;
				}
			}
			if (idx != i) {
				cnt++;
				int temp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = temp;
				if (cnt == k) {
					printResult();
					System.exit(0);
				}
			}
		}
	}

	private static void printResult() {
		System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}

	public static void main(String[] args) {
		parseInput();
		selectSort();
		System.out.println(-1);
	}
}
