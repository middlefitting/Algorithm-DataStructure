package 유형.문자열.에너그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				boolean flag = true;

				HashMap<Character, Integer> mapA = new HashMap<>();
				for (int j = 0; j < a.length(); j++) {
					mapA.put(a.charAt(j), mapA.getOrDefault(a.charAt(j), 0) + 1);
				}

				HashMap<Character, Integer> mapB = new HashMap<>();
				for (int j = 0; j < b.length(); j++) {
					mapB.put(b.charAt(j), mapB.getOrDefault(b.charAt(j), 0) + 1);
				}

				for (Character c : mapA.keySet()) {
					if (mapA.getOrDefault(c, 0) != mapB.getOrDefault(c, 0)) {
						flag = false;
					}
				}

				for (Character c : mapB.keySet()) {
					if (mapA.getOrDefault(c, 0) != mapB.getOrDefault(c, 0)) {
						flag = false;
					}
				}
				String result = a + " & " + b;
				if (flag) {
					System.out.println(result + " are anagrams.");
				} else {
					System.out.println(result + " are NOT anagrams.");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
