package 유형.문자열.welcometosmupc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = "WelcomeToSMUPC";
			int n = Integer.parseInt(br.readLine());
			System.out.println(s.charAt((n - 1) % 14));

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
