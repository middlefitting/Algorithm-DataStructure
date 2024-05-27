package 유형.문자열.팰린드롬수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String STOP = "0";
	static String YES = "yes\n";
	static String NO = "no\n";

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder sb = new StringBuilder();
			while (true) {
				StringBuilder s = new StringBuilder(br.readLine());
				if (s.toString().equals(STOP)) {
					break;
				}
				StringBuilder reverse = new StringBuilder();
				for (int i = 0; i < s.length(); i++) {
					reverse.append(s.charAt(s.length() - i - 1));
				}
				if (s.toString().equals(reverse.toString())) {
					sb.append(YES);
				} else {
					sb.append(NO);
				}
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
