package 유형.구현.fastestsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int idx = 0;
			while (true) {
				idx++;
				String s = br.readLine();
				if (s.equals("0")) {
					break;
				}
				System.out.println("Case " + idx + ": Sorting... done!");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
