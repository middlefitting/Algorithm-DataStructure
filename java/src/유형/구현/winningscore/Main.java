package 유형.구현.winningscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int a = 0;
			int b = 0;

			a += Integer.parseInt(br.readLine()) * 3;
			a += Integer.parseInt(br.readLine()) * 2;
			a += Integer.parseInt(br.readLine()) * 1;
			b += Integer.parseInt(br.readLine()) * 3;
			b += Integer.parseInt(br.readLine()) * 2;
			b += Integer.parseInt(br.readLine()) * 1;

			if (a > b) {
				System.out.println("A");
			} else if (a < b) {
				System.out.println("B");
			} else {
				System.out.println("T");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
