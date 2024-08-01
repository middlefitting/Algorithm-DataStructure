package 유형.문자열.chino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			int colon = 0;
			int under = 0;

			for (char c : s.toCharArray()) {
				if (c == ':') {
					colon++;
				} else if (c == '_') {
					under++;
				}
			}

			System.out.println(s.length() + colon + under * 5);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
