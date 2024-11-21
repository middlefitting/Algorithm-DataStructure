package 유형.구현.kubers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());

			int result = 0;

			for (int i = 1; i <= n; i++) {
				result += i * i * i;
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
