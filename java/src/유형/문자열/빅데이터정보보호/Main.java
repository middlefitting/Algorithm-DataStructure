package 유형.문자열.빅데이터정보보호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int security = 0;
			int bigdata = 0;
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 's') {
					security++;
				} else if (s.charAt(i) == 'b') {
					bigdata++;
				}
			}

			if (bigdata > security) {
				System.out.println("bigdata?");
			} else if (security > bigdata) {
				System.out.println("security!");
			} else {
				System.out.println("bigdata? security!");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
