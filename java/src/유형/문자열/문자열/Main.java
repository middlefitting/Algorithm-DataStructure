package 유형.문자열.문자열;

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

			int result = Integer.MAX_VALUE;
			for (int i = 0; i <= b.length() - a.length(); i++) {
				int diff = 0;
				for (int j = 0; j < a.length(); j++) {
					if (a.charAt(j) != b.charAt(j + i)) {
						diff++;
					}
				}
				result = Math.min(result, diff);
			}
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
