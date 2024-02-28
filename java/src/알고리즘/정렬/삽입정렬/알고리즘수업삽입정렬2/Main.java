package 알고리즘.정렬.삽입정렬.알고리즘수업삽입정렬2;

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
	private static StringBuffer result = new StringBuffer();
	private static int cnt = 0;

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

	private static void insertSort() {
		for (int i = 0; i < n; i++) {
			int x = arr[i];
			int j = -1;
			while (i + j >= 0 && arr[i + j] > x) {
				arr[i + j + 1] = arr[i + j];
				saveResult(arr[i + j]);
				j--;
			}
			if (j != -1) {
				arr[i + j + 1] = x;
				saveResult(x);
			}
			if (cnt >= k) {
				break;
			}
		}
	}

	private static void saveResult(int x) {
		cnt++;
		if (cnt == k) {
			Arrays.stream(arr).forEach(i -> result.append(i).append(" "));
		}
	}

	public static void main(String[] args) {
		parse();
		insertSort();
		if (cnt >= k) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}
}
