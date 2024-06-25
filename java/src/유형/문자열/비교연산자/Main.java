package 유형.문자열.비교연산자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int idx = 0;
			while (true) {
				idx++;
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				String operator = st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				if (operator.equals("E")) {
					break;
				}
				System.out.println("Case " + idx + ": " + result(a, b, operator));
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static String result(int a, int b, String operator) {
		if (operator.equals(">")) {
			return a > b ? "true" : "false";
		}
		if (operator.equals(">=")) {
			return a >= b ? "true" : "false";
		}
		if (operator.equals("<")) {
			return a < b ? "true" : "false";
		}
		if (operator.equals("<=")) {
			return a <= b ? "true" : "false";
		}
		if (operator.equals("==")) {
			return a == b ? "true" : "false";
		}
		if (operator.equals("!=")) {
			return a != b ? "true" : "false";
		}
		return null;
	}
}
