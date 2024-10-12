package 유형.해시.사이클단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<>();
			int result = 0;
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				if (!set.contains(s)) {
					for (int j = 0; j <= s.length(); j++) {
						String temp = s.substring(j);
						temp += s.substring(0, j);
						set.add(temp);
					}
					result++;
				}
			}
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
