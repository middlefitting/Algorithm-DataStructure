package 유형.문자열.문자가몇갤까;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				String s = br.readLine();
				if (s.equals("#")) {
					break;
				}
				HashSet<Character> map = new HashSet<>();
				for (int i = 0; i < s.length(); i++) {
					char c = s.charAt(i);
					if (c <= 'z' && c >= 'a') {
						map.add(c);
					} else if (c <= 'Z' && c >= 'A') {
						map.add(Character.toLowerCase(c));
					}
				}
				System.out.println(map.size());
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
