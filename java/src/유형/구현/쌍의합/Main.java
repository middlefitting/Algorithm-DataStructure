package 유형.구현.쌍의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(br.readLine());
				String msg = "Pairs for " + x + ":";

				boolean flag = false;

				for (int j = 1; j <= x / 2; j++) {
					if (j >= x - j) {
						break;
					}

					if (flag) {
						msg += ",";
					}
					msg = msg + " " + j + " " + (x - j);

					flag = true;
				}

				System.out.println(msg);
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
