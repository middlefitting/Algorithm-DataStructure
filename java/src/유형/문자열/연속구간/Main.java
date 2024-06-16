package 유형.문자열.연속구간;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			for (int i = 0; i < 3; i++) {
				int result = 1;
				String temp = br.readLine();
				int cnt = 1;
				for (int j = 1; j < 8; j++) {
					if (temp.charAt(j) == temp.charAt(j - 1)) {
						cnt++;
					} else {
						result = Math.max(cnt, result);
						cnt = 1;
					}
				}
				result = Math.max(cnt, result);
				System.out.println(result);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
