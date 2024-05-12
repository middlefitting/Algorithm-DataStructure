package 알고리즘.easy.그게무슨코드니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			boolean flag = true;
			for (int i = 0; i < s.length(); i++) {
				char c =  s.charAt(i);
				if (i == 0 || i == s.length() - 1) {
					if (c != '"') {
						flag = false;
						break;
					}
				} else {
					if (c == '"') {
						flag = false;
						break;
					}
				}
			}
			if (s.length() < 3 || !flag) {
				System.out.println("CE");
			} else {
				System.out.println(s.substring(1, s.length() - 1));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
