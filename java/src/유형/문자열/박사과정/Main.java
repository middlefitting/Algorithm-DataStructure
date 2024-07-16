package 유형.문자열.박사과정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				String[] arr = br.readLine().split("\\+");
				if (arr.length == 1) {
					System.out.println("skipped");
				} else {
					System.out.println(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
				}
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
