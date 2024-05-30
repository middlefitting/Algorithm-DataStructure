package 유형.dp.피보나치수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			long a1 = 0;
			long a2 = 1;

			for (int i = 2; i <= n; i++) {
				long temp = a1 + a2;
				a1 = a2;
				a2 = temp;
			}
			System.out.println(a2);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
