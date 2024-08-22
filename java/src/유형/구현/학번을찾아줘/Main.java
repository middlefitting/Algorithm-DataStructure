package 유형.구현.학번을찾아줘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}

			long result = 0;

			if (arr[0] > arr[2]) {
				result += (arr[0] - arr[2]) * 508;
			} else {
				result += (arr[2] - arr[0]) * 108;
			}

			if (arr[1] > arr[3]) {
				result += (arr[1] - arr[3]) * 212;
			} else {
				result += (arr[3] - arr[1]) * 305;
			}

			if (n >= 5) {
				result += arr[4] * 707;
			}

			System.out.println(result * 4763);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
