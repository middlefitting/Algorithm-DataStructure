package 알고리즘.정렬.병합정렬.알고리즘수업병합정렬3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	private static int n;
	private static String result = "0";
	private static int[] arr;
	private static int[] target;
	private static int cnt;

	public static void main(String[] args) {
		parse();
		mergeSort(0, n - 1);
		System.out.println(result);
	}

	private static void mergeSort(int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			mergeSort(s, m);
			mergeSort(m + 1, e);
			merge(s, m, e);
		}
	}

	private static void merge(int s, int m, int e) {
		int i = s;
		int j = m + 1;
		int t = 0;
		int[] tmp = new int[e - s + 1];
		while (i <= m && j <= e) {
			if (arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}
		while (i <= m) {
			tmp[t++] = arr[i++];
		}
		while (j <= e) {
			tmp[t++] = arr[j++];
		}
		i = s;
		t = 0;
		while (i <= e) {
			updateResult(i, t, tmp);
			arr[i++] = tmp[t++];
		}
	}

	private static void updateResult(int i, int t, int[] tmp) {
		if (arr[i] != target[i] && tmp[t] == target[i]) {
			cnt++;
		} else if (arr[i] == target[i] && tmp[t] != target[i]) {
			cnt--;
		}
		if (cnt == n) {
			result = "1";
		}
	}

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
			if (cnt == n) {
				result = "1";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
