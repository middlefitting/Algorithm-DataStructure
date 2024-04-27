package 알고리즘.easy.특별한가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			System.out.println(m / n * k);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
