package 유형.문자열.팔진수이진수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuffer sb = new StringBuffer();
			String number = br.readLine();
			sb.append(Integer.toBinaryString(Integer.parseInt(number.substring(0, 1), 8)));
			for (int i = 1; i < number.length(); i++) {
				String temp = Integer.toBinaryString(Integer.parseInt(number.substring(i, i + 1), 8));
				for (int j = 0; j < 3 - temp.length(); j++) {
					sb.append(0);
				}
				sb.append(temp);
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
