package 유형.호텔방번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			while (true) {
				String s = br.readLine();

				if (s == null || s.isEmpty()) {
					break;
				}

				int[] startAndEnd = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

				int cnt = 0;
				for (int i = startAndEnd[0]; i <= startAndEnd[1]; i++) {
					char[] temp = String.valueOf(i).toCharArray();
					HashSet<Character> set = new HashSet<>();
					for (char c : temp) {
						set.add(c);
					}
					if (set.size() == temp.length) {
						cnt++;
					}
				}

				System.out.println(cnt);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
