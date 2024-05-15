package 알고리즘.easy.j박스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				if (i != 0) {
					System.out.println();
				}
				int m = Integer.parseInt(br.readLine());
				if (m == 0) {
					continue;
				} else
				if (m == 1) {
					System.out.println("#");
					continue;
				} else if (m == 2) {
					System.out.println("##");
					System.out.println("##");
					continue;
				}
				for (int j = 0; j < m; j++) {
					System.out.print("#");
				}
				System.out.println();
				for (int j = 0; j < m - 2; j++) {
					System.out.print("#");
					for (int k = 0; k < m - 2; k++) {
						System.out.print("J");
					}
					System.out.println("#");
				}
				for (int j = 0; j < m; j++) {
					System.out.print("#");
				}
				System.out.println();
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
