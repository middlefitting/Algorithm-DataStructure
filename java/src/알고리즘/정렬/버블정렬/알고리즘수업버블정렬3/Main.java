package 알고리즘.정렬.버블정렬.알고리즘수업버블정렬3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] arr2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			boolean[] isMatch = new boolean[n];
			int matchCnt = 0;
			boolean find = false;

			for (int i = 0; i < n; i++) {
				if (arr[i] == arr2[i]) {
					isMatch[i] = true;
					matchCnt++;
				}
			}
			if (matchCnt == n) {
				find = true;
			}

			while (!find) {
				boolean flag = false;
				for (int i = 0; i < n - 1; i++) {
					int j = i + 1;
					if (arr[i] > arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						if (arr[i] == arr2[i] && !isMatch[i]) {
							isMatch[i] = true;
							matchCnt++;
						} else if (arr[i] != arr2[i] && isMatch[i]) {
							isMatch[i] = false;
							matchCnt--;
						}
						if (arr[j] == arr2[j] && !isMatch[j]) {
							isMatch[j] = true;
							matchCnt++;
						} else if (arr[j] != arr2[j] && isMatch[j]) {
							isMatch[j] = false;
							matchCnt--;
						}
						if (matchCnt == n) {
							find = true;
						}
						flag = true;
					}
				}
				if (!flag) {
					break;
				}
			}
			if (!find) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
