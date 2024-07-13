package 유형.문자열.지영공주님의마법거울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine();
			}
			int k = Integer.parseInt(br.readLine());

			if (k == 2) {
				for (int i = 0; i < n; i++) {
					arr[i] = new StringBuilder(arr[i]).reverse().toString();
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if (k == 3) {
					sb.append(arr[n - i - 1]).append("\n");

				} else {
					sb.append(arr[i]).append("\n");
				}
			}
			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
