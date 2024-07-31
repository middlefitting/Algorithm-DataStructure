package 유형.문자열.끝말잇기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			HashMap<Character, Integer> map = new HashMap<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String s = st.nextToken();
				map.put(s.charAt(s.length() - 1), map.getOrDefault(s.charAt(s.length() - 1), 0) + 1);
				if (s.charAt(0) != s.charAt(s.length() - 1) || map.getOrDefault(s.charAt(0), 0) > 1) {
					map.put(s.charAt(0), map.getOrDefault(s.charAt(0), 0) - 1);
				}
			}

			int cnt = 0;

			for (int i : map.values()) {
				cnt += Math.max(0, i);
			}

			if (cnt <= 1) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
