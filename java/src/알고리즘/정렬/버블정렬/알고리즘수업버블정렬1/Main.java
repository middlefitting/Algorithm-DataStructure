package 알고리즘.정렬.버블정렬.알고리즘수업버블정렬1;

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
			int k = Integer.parseInt(st.nextToken());
			int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			StringBuffer sb = new StringBuffer();
			int result = 0;
			while (result < k) {
				boolean flag = false;
				for (int i = 0; i < n - 1; i++) {
					int j = i + 1;
					if (arr[i] > arr[j]) {
						result++;
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						flag = true;
						if (result == k) {
							sb.append(arr[i]).append(" ").append(arr[j]);
						}
					}
				}
				if (!flag) {
					break;
				}
			}
			if (result < k) {
				System.out.println(-1);
			} else {
				System.out.println(sb);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
