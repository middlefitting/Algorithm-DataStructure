package 유형.구현.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static long M = 1234567891;
	private static long R = 31;

	// 모듈로 연산을 활용해서 제곱마다 나머지를 구한다
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			long result = 0;
			for (int i = 0; i < n; i++) {
				result += hash(s.charAt(i), i);
			}
			System.out.println(result % M);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static long hash(char c, int pow) {
		long result = (int) c - 96;
		for (int i = 0; i < pow; i++) {
			result = (result * R) % M;
		}
		return result;
	}
}
