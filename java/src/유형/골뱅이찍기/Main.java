package 유형.골뱅이찍기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n * 5; j++) {
					System.out.print("@");
				}
				System.out.println();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print("@");
				}
				System.out.println();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n * 5; j++) {
					System.out.print("@");
				}
				System.out.println();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print("@");
				}
				System.out.println();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n * 5; j++) {
					System.out.print("@");
				}
				System.out.println();
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
