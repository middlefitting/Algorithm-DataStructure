package 유형.구현.스위트콘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println(Integer.parseInt(br.readLine()) / 11 * 10);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
