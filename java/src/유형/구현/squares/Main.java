package 유형.구현.squares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			System.out.println("The largest square has side length " + (int) (Math.sqrt(n)) + ".");
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
