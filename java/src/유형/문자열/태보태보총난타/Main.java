package 유형.문자열.태보태보총난타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();

			boolean isLeft = true;

			int left = 0;
			int right = 0;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '@') {
					if (isLeft) {
						left++;
					} else {
						right++;
					}
				}
				if (s.charAt(i) == '0') {
					isLeft = false;
				}
			}

			System.out.println(left + " " + right);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
