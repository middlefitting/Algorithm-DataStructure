package 유형.구현.footballteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder sb = new StringBuilder();
			while (true) {
				String s = br.readLine();
				if (s == null || s.equals("")) {
					break;
				}
				for (char c : s.toCharArray()) {
					if (c == 'i') {
						sb.append('e');
					} else if (c == 'e') {
						sb.append('i');
					} else if (c == 'E') {
						sb.append('I');
					} else if (c == 'I') {
						sb.append('E');
					} else {
						sb.append(c);
					}
				}
				sb.append("\n");
			}

			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
