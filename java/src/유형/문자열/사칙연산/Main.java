package 유형.문자열.사칙연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				long a = Long.parseLong(st.nextToken());
				String operation = st.nextToken();
				long b = Long.parseLong(st.nextToken());
				st.nextToken();
				long result = Long.parseLong(st.nextToken());
				if (func(a, b, operation) == result) {
					sb.append("correct\n");
				} else {
					sb.append("wrong answer\n");
				}
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static long func(long a, long b, String operation) {
		if (operation.equals("+")) {
			return a + b;
		} else if (operation.equals("-")) {
			return a - b;
		} else if (operation.equals("*")) {
			return a * b;
		} else if (operation.equals("/")) {
			return a / b;
		}
		throw new RuntimeException();
	}
}
