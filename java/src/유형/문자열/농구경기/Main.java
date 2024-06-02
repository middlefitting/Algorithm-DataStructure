package 유형.문자열.농구경기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			String answer = "";
			for (int i = 0; i < n; i++) {
				String temp = br.readLine().substring(0, 1);
				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}
			for (String key : map.keySet().stream().sorted().collect(Collectors.toList())) {
				if (map.get(key) >= 5) {
					answer += key;
				}
			}
			if (!answer.equals("")) {
				System.out.println(answer);
			} else {
				System.out.println("PREDAJA");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
