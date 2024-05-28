package 유형.문자열.팰린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			HashMap<String, Integer> map = new HashMap<>();

			String result = "";
			for (int i = 0; i < s.length(); i++) {
				String temp = s.substring(i, i + 1);
				map.put(temp, map.getOrDefault(temp, 0 ) + 1);
				if (map.getOrDefault(temp, 0) != 0 && map.getOrDefault(temp, 0) % 2 == 0) {
					result += temp;
				}
			}
			char[] arr = result.toCharArray();
			Arrays.sort(arr);
			result = "";
			for (int i = 0; i < arr.length; i++) {
				result += arr[i];
			}

			int cnt = 0;
			String one = "";
			for (String key : map.keySet()) {
				int value = map.get(key);
				if (value % 2 > 0) {
					cnt++;
					one = key;
				}
			}

			if (cnt > 1) {
				System.out.println("I'm Sorry Hansoo");
			} else {
				int l = result.length();
				result += one;
				for (int i = 0; i < l; i++) {
					result += result.substring(l - 1 - i, l - i);
				}
				System.out.println(result);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
