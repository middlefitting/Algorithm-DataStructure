package 유형.문자열.greetings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();

			StringBuilder sb = new StringBuilder();

			for (char c : s.toCharArray()) {
				sb.append(c);
				if (c == 'e') {
					sb.append(c);
				}
			}

			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
