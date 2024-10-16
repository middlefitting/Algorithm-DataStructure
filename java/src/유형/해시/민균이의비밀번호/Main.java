package 유형.해시.민균이의비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				set.add(s);
				String sReversed = String.valueOf(new StringBuilder(s).reverse());
				if (set.contains(sReversed)) {
					System.out.print(s.length() + " ");
					System.out.println(s.charAt(s.length() / 2));
				}
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
