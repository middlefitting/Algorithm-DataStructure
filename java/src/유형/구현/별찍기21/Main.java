package 유형.구현.별찍기21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder();

			if (n == 1) {
				System.out.println("*");
				return;
			}


			for (int i = 0; i < n * 2; i++) {
				boolean flag = i % 2 == 0;

				for (int j = 0; j < n; j++) {
					if (flag) {
						sb.append("*");
					} else {
						sb.append(" ");
					}
					flag = !flag;
				}
				sb.append("\n");
			}

			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
