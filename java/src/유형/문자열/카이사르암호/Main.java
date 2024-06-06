package 유형.문자열.카이사르암호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			String answer = "";
			for (int i = 0; i < s.length(); i++) {
				char temp = (char)(s.charAt(i) - 3);
				if (temp < 65) {
					temp += 25;
				}
				answer += temp;
			}
			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
