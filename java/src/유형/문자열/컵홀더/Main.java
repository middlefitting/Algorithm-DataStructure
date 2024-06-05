package 유형.문자열.컵홀더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.substring(i, i + 1).equals("S")) {
					cnt++;
				}
			}
			cnt += (s.length() - cnt) / 2;
			System.out.println(Math.min(cnt + 1, s.length()));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
