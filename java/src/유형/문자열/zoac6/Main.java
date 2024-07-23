package 유형.문자열.zoac6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				if (s.contains("01") || s.contains("OI")) {
					cnt++;
				}
			}
			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
