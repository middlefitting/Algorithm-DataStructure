package 유형.문자열.도비의영어공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;
			while (true) {
				st = new StringTokenizer(br.readLine());
				String target = st.nextToken();
				if (target.equals("#")) {
					break;
				}
				int result = 0;
				try {
					while (true) {
						String s = st.nextToken();
						if (s == null || s.isEmpty()) {
							break;
						}
						for (int i = 0; i < s.length(); i++) {
							String temp = s.substring(i, i + 1).toLowerCase();
							if (temp.equals(target.toLowerCase())) {
								result++;
							}
						}
					}
				} catch (Exception e) {

				}
				System.out.println(target + " " + result);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
