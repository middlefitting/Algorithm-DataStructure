package 유형.문자열.애너그램만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s1 = br.readLine();
			String s2 = br.readLine();

			HashMap<String, Integer> map1 = getMap(s1);
			HashMap<String, Integer> map2 = getMap(s2);

			int answer = 0;
			for (int i = 'a'; i <= 'z'; i++) {
				String temp = String.valueOf((char) i);
				answer += Math.abs(map1.getOrDefault(temp, 0) - map2.getOrDefault(temp, 0));
			}
			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static HashMap<String, Integer> getMap(String s) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			String temp = s.substring(i, i + 1);
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}
		return map;
	}
}
