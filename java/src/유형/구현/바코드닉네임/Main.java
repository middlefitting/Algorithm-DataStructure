package 유형.구현.바코드닉네임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			String s = br.readLine();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				String temp = s.substring(i, i + 1);
				String lower = temp.toLowerCase();
				String upper = temp.toUpperCase();

				if (temp.equals(lower)) {
					sb.append(upper);
				} else {
					sb.append(lower);
				}
			}

			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
