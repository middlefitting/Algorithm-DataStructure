package 유형.문자열.괄호제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

public class Main {

	private static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					cnt++;
				}
			}
			logic(s, cnt);
			StringBuffer sb = new StringBuffer();
			set.stream().sorted().forEach((temp) -> sb.append(temp).append("\n"));
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static void logic(String s, int cnt) {
		for (int i = 1; i <= cnt; i++) {
			int idx = 0;
			int sCnt = 0;
			int eCnt = 0;

			int locA = 0;
			int locB = 0;
			for (int j = 0; j < s.length(); j++) {
				if (idx != i && s.charAt(j) == '(') {
					idx++;
					if (idx == i) {
						locA = j;
					}
					continue;
				}

				if (idx == i && s.charAt(j) == '(') {
					sCnt++;
				}
				if (idx == i && s.charAt(j) == ')') {
					if (eCnt == sCnt) {
						locB = j;
						break;
					}
					eCnt++;
				}
			}
			String temp = s.substring(0, locA) + s.substring(locA + 1, locB) + s.substring(locB + 1);
			if (!set.contains(temp)) {
				set.add(temp);
				logic(temp, cnt - 1);
			}
		}
	}
}
