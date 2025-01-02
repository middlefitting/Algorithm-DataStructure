package 유형.구현.threesixnine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());

			int result = 0;

			for (int i = 3; i <= n; i++) {
				int num = i;

				while (num > 0) {
					int digit = num % 10;
					if (digit == 3 || digit == 6 || digit == 9) {
						result++;
					}
					num /= 10;
				}
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
