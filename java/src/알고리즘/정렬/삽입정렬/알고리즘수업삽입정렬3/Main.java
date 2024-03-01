package 알고리즘.정렬.삽입정렬.알고리즘수업삽입정렬3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	private static int n;
	private static int[] arr;
	private static int[] target;

	private static String result = "0";
	private static int cnt = 0;

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			target = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < n; i++) {
				if (arr[i] == target[i]) {
					cnt++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void insertSort() {
		for (int i = 0; i < n; i++) {
			int x = arr[i];
			int j = -1;
			while (i + j >= 0 && arr[i + j] > x) {
				saveResult(i + j + 1, arr[i + j]);
				j--;
			}
			if (j != -1) {
				saveResult(i + j + 1, x);
			}
		}
	}

	private static void saveResult(int idx, int x) {
		if (arr[idx] != target[idx] && x == target[idx]) {
			cnt++;
		} else if (arr[idx] == target[idx] && x != target[idx]) {
			cnt--;
		}
		arr[idx] = x;
		if (cnt == n) {
			result = "1";
		}
	}

	public static void main(String[] args) {
		parse();
		insertSort();
		System.out.println(result);
	}
}
