package 유형.이분탐색.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[] arr;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			int m = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < m; i++) {
				boolean result = binarySearch(Integer.parseInt(st.nextToken()));
				if (result) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static boolean binarySearch(int num) {
		int s = 0;
		int e = n - 1;

		if (arr[s] == num) {
			return true;
		}
		if (arr[e] == num) {
			return true;
		}

		while (s < e - 1) {
			int m = (s + e) / 2;
			if (arr[m] == num) {
				return true;
			} else if (arr[m] < num) {
				s = m;
			} else {
				e = m;
			}
		}
		return false;
	}
}
