package 단계별로풀어보기.재귀.팩토리얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long n = Long.parseLong(br.readLine());
			long result = 1;
			for (long i = 1; i <= n; i++) {
				result *= i;
			}
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
