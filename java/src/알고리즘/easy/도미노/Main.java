package 알고리즘.easy.도미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long a = Integer.parseInt(br.readLine());
			int result = 0;
			for (int i = 1; i <= a + 1; i++) {
				result += i;
			}
			System.out.println(result * a);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
