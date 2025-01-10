package 유형.구현.와우와쿼리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				int result = 0;
				for (int j = 0; j < s.length() - 2; j++) {
					if (s.substring(j, j + 3).equals("WOW")) {
						result++;
					}
				}
				System.out.println(result);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
