package 유형.구현.완전제곱수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());

			int cnt = 0;

			for (int i = 1; i <= 500; i++) {
				for (int j = i; j <= 500; j++) {

					if (j * j - i * i == n) {
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
