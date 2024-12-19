package 유형.구현.uos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());

			int result = n % 3;

			if (result == 0) {

				System.out.println("S");
			} else if (result == 1) {

				System.out.println("U");
			} else {

				System.out.println("O");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
