package 알고리즘.정렬.병합정렬.알고리즘수업병합정렬2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	private static int n;
	private static int k;
	private static int idx = 0;
	private static String result = "-1";
	private static int[] arr;

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
			arr[i++] = tmp[t++];
			calc(tmp, t, s);
		}
	}

	private static void calc(int[] tmp, int t, int s) {
		idx++;
		if (idx == k) {
			int[] answer = Arrays.stream(arr).toArray();
			for (int i = 0; i < t; i++) {
				answer[i + s] = tmp[i];
			}
			result = Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" "));
			System.out.println(result);
			System.exit(0);
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
