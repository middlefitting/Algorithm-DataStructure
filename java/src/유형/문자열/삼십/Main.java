package 유형.문자열.삼십;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		char[] arr = parse();
		logic(arr);
	}

	private static void logic(char[] arr) {
		Arrays.sort(arr);

		int result = 0;
		for (char c : arr) {
			result += (c - '0');
		}

		if (arr[0] != '0' || result % 3 > 0) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder(String.valueOf(arr));
			System.out.println(sb.reverse());
		}
	}

	private static char[] parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			return br.readLine().toCharArray();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
