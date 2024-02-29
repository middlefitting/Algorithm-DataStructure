package 알고리즘.정렬.퀵정렬.알고리즘수업퀵정렬3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

	private static int n;

	private static int k = 0;
	private static boolean[] same;
	private static int[] arr;
	private static int[] target;

	private static int result = 0;

	public static void main(String[] args) {
		parse();
		quickSort(0, n - 1);
		System.out.println(result);
	}

	private static void quickSort(int s, int e) {
		if (s < e) {
			int m = partition(s, e);
			quickSort(s, m - 1);
			quickSort(m + 1, e);
		}
	}

	private static int partition(int s, int e) {
		int x = arr[e];
		int i = s - 1;
		updateAnswer(0, 0);
		for (int j = s; j < e; j++) {
			if (arr[j] <= x) {
				int temp = arr[++i];
				arr[i] = arr[j];
				arr[j] = temp;
				updateAnswer(i, j);
			}
		}
		if (i + 1 != e) {
			int temp = arr[i + 1];
			arr[i + 1] = arr[e];
			arr[e] = temp;
			updateAnswer(i + 1, e);
		}
		return i + 1;
	}

	private static void updateAnswer(int i, int j) {
		if (arr[i] == target[i] && same[i] == false) {
			same[i] = true;
			k++;
		} else if (arr[i] != target[i] && same[i] == true) {
			same[i] = false;
			k--;
		}
		if (arr[j] == target[j] && same[j] == false) {
			same[j] = true;
			k++;
		} else if (arr[j] != target[j] && same[j] == true) {
			same[j] = false;
			k--;
		}
		if (k == n) {
			result = 1;
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			same = new boolean[n];
			arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			target = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < n; i++) {
				if (arr[i] == target[i]) {
					same[i] = true;
					k++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

