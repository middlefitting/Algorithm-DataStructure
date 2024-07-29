package 유형.문자열.재수강;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				String compare = br.readLine();
				boolean flag = true;
				for (int j = 0; j < 5; j++) {
					if (s.charAt(j) != compare.charAt(j)) {
						flag = false;
					}
				}
				if (flag) {
					cnt++;
				}
			}

			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
