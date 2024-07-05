package 유형.문자열.밈투표2033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] list = {"Never gonna give you up", "Never gonna give you up", "Never gonna let you down",
				"Never gonna run around and desert you", "Never gonna make you cry",
				"Never gonna say goodbye", "Never gonna tell a lie and hurt you", "Never gonna stop"};

			int n = Integer.parseInt(br.readLine());

			boolean flag = true;

			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				boolean tempFlag = false;
				for (String s : list) {
					if (s.equals(temp)) {
						tempFlag = true;
					}
				}
				if (tempFlag == false) {
					flag = false;
				}
			}
			if (flag) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
