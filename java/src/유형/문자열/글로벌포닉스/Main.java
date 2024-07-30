package 유형.문자열.글로벌포닉스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			boolean l = false;
			boolean k = false;
			boolean p = false;

			for (int i = 0; i < 3; i++) {
				String s = br.readLine();
				if (s.charAt(0) == 'l') {
					l = true;
				} else if (s.charAt(0) == 'k') {
					k = true;
				} else if (s.charAt(0) == 'p') {
					p = true;
				}
			}

			if (l && k && p) {
				System.out.println("GLOBAL");
			} else {
				System.out.println("PONIX");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
