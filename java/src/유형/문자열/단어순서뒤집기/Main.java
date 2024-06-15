package 유형.문자열.단어순서뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				String[] arr = br.readLine().split(" ");
				sb.append(String.format("Case #%d: ", i + 1));
				for (int j = 0; j < arr.length; j++) {
					sb.append(arr[arr.length - j - 1]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
