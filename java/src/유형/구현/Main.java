package 유형.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				long a = Long.parseLong(br.readLine());
				if (a == 0) {
					break;
				}
				long result = 0;
				for (long i = 1; i <= a; i++) {
					result += i;
				}
				System.out.println(result);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
