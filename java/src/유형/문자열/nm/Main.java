package 유형.문자열.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			int m = Integer.parseInt(st.nextToken());

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < Integer.parseInt(n); i++) {
				sb.append(n);
			}

			if (sb.length() > m) {
				System.out.println(sb.substring(0, m));
			} else {
				System.out.println(sb);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
