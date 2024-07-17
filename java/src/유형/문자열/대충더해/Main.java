package 유형.문자열.대충더해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String a = st.nextToken();
			String b = st.nextToken();

			String temp;

			if (a.length() < b.length()) {
				temp = a;
				a = b;
				b = temp;
			}

			String result = "";
			for (int i = 0; i < a.length(); i++) {
				if (b.length() - i - 1 < 0) {
					result = a.charAt(a.length() - i - 1) + result;
				} else {
					result = (Integer.parseInt(String.valueOf(a.charAt(a.length() - i - 1))) + Integer.parseInt(
						String.valueOf(b.charAt(b.length() - i - 1)))) + result;
				}
			}
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
