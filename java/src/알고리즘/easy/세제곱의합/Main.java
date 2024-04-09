package 알고리즘.easy.세제곱의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(sum(n));
			System.out.println(pow(n));
			System.out.println(powThree(n));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static int pow(int n) {
		int result = 0 ;
		for (int i = 1; i <= n; i++) {
			result += i;
		}
		return result * result;
	}

	private static int powThree(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += i * i * i;
		}
		return result;
	}

	private static int sum(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}
}
