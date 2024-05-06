package 알고리즘.easy.tournamentselection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int result = 0;
			for (int i = 0; i < 6; i++) {
				String temp = br.readLine();
				if (temp.equals("W")) {
					result++;
				}
			}

			if (result == 0) {
				System.out.println(-1);
			} else if (result <= 2) {
				System.out.println(3);
			} else if (result <= 4) {
				System.out.println(2);
			} else {
				System.out.println(1);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
