package 유형.문자열.등장하지않는문자의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int result = 0;
			for (int i = 'A'; i <= 'Z'; i++) {
				result += i;
			}

			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				HashSet<Integer> map = new HashSet<>();
				String s = br.readLine();
				int temp = result;
				for (int j = 0; j < s.length(); j++) {
					if (!map.contains((int)s.charAt(j))) {
						map.add((int) s.charAt(j));
						temp -= s.charAt(j);
					}
				}
				System.out.println(temp);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
