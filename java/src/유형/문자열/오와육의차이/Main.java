package 유형.문자열.오와육의차이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			StringBuilder sb = new StringBuilder();
			sb.append(calc(a, false) + calc(b, false)).append(" ");
			sb.append(calc(a, true) + calc(b, true));
			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int calc(String a, boolean b) {
		String result = "";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '6' && b == false) {
				result += "5";
			} else if (a.charAt(i) == '5' && b == true) {
				result += "6";
			} else {
				result += a.substring(i, i + 1);
			}
		}
		return Integer.parseInt(result);
	}
}
