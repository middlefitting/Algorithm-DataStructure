package 유형.문자열.mbti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String target = br.readLine();
			int n = Integer.parseInt(br.readLine());
			int result = 0;

			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				if (temp.equals(target)) {
					result++;
				}
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
