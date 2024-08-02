package 유형.문자열.ibm빼기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();

			for (int i = 1; i <= n; i++) {
				sb.append("String #" + i + "\n");
				String s = br.readLine();

				String temp = "";
				for (char c : s.toCharArray()) {
					if (c == 'Z') {
						temp += 'A';
					} else {
						temp += (char)(c + 1);
					}
				}
				sb.append(temp + "\n");
				sb.append("\n");
			}

			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
