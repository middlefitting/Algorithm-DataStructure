package 유형.구현.십팩토리얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long n = Long.parseLong(br.readLine());

			long result = 6;

			while (n > 10) {
				result *= n--;
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
