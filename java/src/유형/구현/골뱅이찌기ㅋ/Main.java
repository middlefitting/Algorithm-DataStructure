package 유형.구현.골뱅이찌기ㅋ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n * 5; j++) {
					sb.append("@");
				}

				sb.append("\n");
			}

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n; j++) {
					sb.append("@");
				}

				sb.append("\n");
			}

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n * 5; j++) {
					sb.append("@");
				}

				sb.append("\n");
			}

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n; j++) {
					sb.append("@");
				}

				sb.append("\n");
			}

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n; j++) {
					sb.append("@");
				}

				sb.append("\n");
			}

			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}

