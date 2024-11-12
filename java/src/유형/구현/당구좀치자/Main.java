package 유형.구현.당구좀치자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			long gage = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				long today = Long.parseLong(st.nextToken());
				if (today == 0) {
					gage--;
				} else {
					gage++;
				}
				arr[i] = gage;
			}

			System.out.println(Arrays.stream(arr).sum());
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
