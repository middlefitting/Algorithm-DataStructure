package 유형.문자열.joi와ioi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			String joi = "JOI";
			String ioi = "IOI";

			int joiCnt = 0;
			int ioiCnt = 0;

			for (int i = 0; i < s.length() - 2; i++) {
				String temp = s.substring(i, i + 3);
				if (joi.equals(temp)) {
					joiCnt++;
				} else if (ioi.equals(temp)) {
					ioiCnt++;
				}
			}
			System.out.println(joiCnt);
			System.out.println(ioiCnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
