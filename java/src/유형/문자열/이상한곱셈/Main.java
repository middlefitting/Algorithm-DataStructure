package 유형.문자열.이상한곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			long a = parse(st.nextToken());
			long b = parse(st.nextToken());

			System.out.println(a * b);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static long parse(String nextToken) {
		int l = nextToken.length();
		long result = 0;
		for (int i = 0; i < l; i++) {
			result += Long.parseLong(nextToken.substring(i, i + 1));
		}
		return result;
	}
}
