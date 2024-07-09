package 유형.문자열.이문제는d2입니다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			if (s.contains("D2") || s.contains("d2")) {
				System.out.println("D2");
			} else {
				System.out.println("unrated");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
