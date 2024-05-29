package 유형.문자열.첫글자를대문자로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				if (s.length() > 0) {
					sb.append(s.substring(0, 1).toUpperCase());
				}
				if (s.length() > 1) {
					sb.append(s.substring(1));
				}
				sb.append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
