package 알고리즘.easy.소수가아닌수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static long k;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		System.out.println("1000000000");
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			k = Long.parseLong(br.readLine());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
