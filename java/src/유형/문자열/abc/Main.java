package 유형.문자열.abc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String a = br.readLine();
			String b = br.readLine();
			String c = br.readLine();

			System.out.println(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c));
			System.out.println(Integer.parseInt(a + b) - Integer.parseInt(c));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
