package 단계별로풀어보기.재귀.알고리즘수업병합정렬1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	private static int n;
	private static int k;
	private static int[] arr;
	private static int[] tmp;
	private static int result = -1;
	private static int idx = 0;

	private static void merge_sort(int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(p, q);
			merge_sort(q + 1, r);
			merge(p, q, r);
		}
	}

	private static void merge(int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}
		while (i <= q) {
			tmp[t++] = arr[i++];
		}
		while (j <= r) {
			tmp[t++] = arr[j++];
		}
		i = p;
		t = 0;

		while (i <= r) {
			arr[i++] = tmp[t++];
			idx++;
			if (idx == k) {
				result = arr[i - 1];
			}
		}
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			tmp = new int[n];
			arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			merge_sort(0, n - 1);
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
