package 유형.누적합.슈퍼마리오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int result = 0;
			for (int i = 0; i < 10; i++) {
				int temp = Integer.parseInt(br.readLine());
				if (Math.abs(100 - result) >= Math.abs(100 - temp - result)) {
					result += temp;
				} else {
					break;
				}
			}
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
