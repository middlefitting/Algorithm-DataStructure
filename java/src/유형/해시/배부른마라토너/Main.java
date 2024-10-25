package 유형.해시.배부른마라토너;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> set = new HashMap<>();

			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				set.put(s, set.getOrDefault(s, 0) + 1);
			}

			for (int i = 0; i < n - 1; i++) {
				String s = br.readLine();
				set.put(s, set.getOrDefault(s, 0) - 1);
				if (set.get(s) <= 0) {
					set.remove(s);
				}
			}

			System.out.print(set.keySet().stream().collect(Collectors.joining("")));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
