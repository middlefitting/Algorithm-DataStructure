package 유형.문자열.strfry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				HashMap<Character, Integer> a = toCharMap(st.nextToken());
				HashMap<Character, Integer> b = toCharMap(st.nextToken());
				boolean flag = true;
				for (char c : a.keySet()) {
					if (a.getOrDefault(c, 0) != b.getOrDefault(c, 0)) {
						flag = false;
					}
				}
				for (char c : b.keySet()) {
					if (a.getOrDefault(c, 0) != b.getOrDefault(c, 0)) {
						flag = false;
					}
				}
				if (flag) {
					sb.append("Possible\n");
				} else {
					sb.append("Impossible\n");
				}
			}
			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static HashMap<Character, Integer> toCharMap(String s) {
		HashMap<Character, Integer> result = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			result.put(temp, result.getOrDefault(temp, 0) + 1);
		}
		return result;
	}
}
