package 알고리즘.정렬.퀵정렬.알고리즘수업퀵정렬2;

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
	private static int[] arr;

	private static String result = "-1";
	private static int idx = 0;

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
		for (int j = s; j < e; j++) {
			if (arr[j] <= x) {
				int temp = arr[++i];
				arr[i] = arr[j];
				arr[j] = temp;
				updateAnswer();
			}
		}
		if (i + 1 != e) {
			int temp = arr[i + 1];
			arr[i + 1] = arr[e];
			arr[e] = temp;
			updateAnswer();
		}
		return i + 1;
	}

	private static void updateAnswer() {
		idx++;
		if (idx == k) {
			result = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
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

