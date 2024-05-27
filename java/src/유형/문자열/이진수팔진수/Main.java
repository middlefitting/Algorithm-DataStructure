package 유형.문자열.이진수팔진수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String num = br.readLine();
			StringBuilder sb = new StringBuilder();
			int n = num.length();
			int start = n % 3;
			if (start == 0) {
				start = 3;
			}
			int temp = 0;
			for (int i = 0; i < start; i++) {
				temp *= 2;
				temp += Integer.parseInt(num.substring(i, i + 1));
			}
			sb.append(temp);
			for (int i = start; i < n; i += 3) {
				temp = 0;
				for (int j = 0; j < 3; j++) {
					temp *= 2;
					temp += Integer.parseInt(num.substring(i + j, i + j + 1));
				}
				sb.append(temp);
			}
			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
