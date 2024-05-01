package 알고리즘.easy.dksh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			int n = s.length();
			int cnt = 0;
			for (int i = 0; i < n - 3; i++) {
				if (s.startsWith("DKSH", i)) {
					cnt++;
				}
			}
			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
