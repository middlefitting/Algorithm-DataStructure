package 유형.문자열.럭키스트레이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			int left = 0;
			int right = 0;
			int half = s.length() / 2;
			for (int i = 0; i < s.length(); i++) {
				if (i < half) {
					left += Integer.parseInt(s.substring(i, i + 1));
				} else {
					right += Integer.parseInt(s.substring(i, i + 1));
				}
			}
			if (left == right) {
				System.out.println("LUCKY");
			} else {
				System.out.println("READY");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
