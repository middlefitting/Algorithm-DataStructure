package 유형.구현.zadanie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder s = new StringBuilder(br.readLine());
			System.out.println(s.reverse());
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
