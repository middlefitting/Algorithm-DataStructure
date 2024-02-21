package 알고리즘.정렬.선택정렬.알고리즘수업선택정렬1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	private static int n;
	private static int k;
	private static int[] arr;
	private static ArrayList<int[]> results = new ArrayList<>();

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
		for (int i = n - 1; i >= 0; i--) {
			int idx = i;
			for (int j = 0; j < i; j++) {
				if (arr[idx] < arr[j]) {
					idx = j;
				}
			}
			if (idx != i) {
				results.add(new int[] {arr[i], arr[idx]});
				int temp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = temp;
			}
		}
	}

	private static void printResult() {
		StringBuffer sb = new StringBuffer();
		if (results.size() >= k) {
			sb.append(results.get(k - 1)[0]).append(" ").append(results.get(k - 1)[1]);
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		parseInput();
		selectSort();
		printResult();
	}
}
