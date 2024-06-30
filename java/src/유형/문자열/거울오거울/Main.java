package 유형.문자열.거울오거울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				String s = br.readLine();
				if (s.equals("***")) {
					break;
				}
				for (int i = 0; i < s.length(); i++) {
					System.out.print(s.charAt(s.length() - i - 1));
				}
				System.out.println();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
