package 알고리즘.정렬.버블정렬.알고리즘수업버블정렬2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int result = 0;
			while (true) {
				boolean flag = false;
				for (int i = 0; i < n - 1; i++) {
					int j = i + 1;
					if (arr[i] > arr[j]) {
						result++;
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						flag = true;
					}
					if (result == k) {
						break;
					}
				}
				if (!flag || result == k) {
					break;
				}
			}
			if (result < k) {
				System.out.println(-1);
			} else {
				System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
