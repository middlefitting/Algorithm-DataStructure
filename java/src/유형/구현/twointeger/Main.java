package 유형.구현.twointeger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			String s2 = br.readLine();
			System.out.println(s + s2);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
