package 유형.문자열.caps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			System.out.println(s.toUpperCase());
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
