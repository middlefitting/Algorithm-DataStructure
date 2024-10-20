package 유형.해시.카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			HashMap<Long, Integer> map = new HashMap<>();
			long result = 0;
			for (int i = 0; i < n; i++) {
				long num = Long.parseLong(br.readLine());
				result = num;
				map.put(num, map.getOrDefault(num, 0) + 1);
			}

			for (long i : map.keySet()) {
				if (map.get(result) == map.get(i)) {
					result = Math.min(result, i);
				} else if (map.get(result) < map.get(i)) {
					result = i;
				}
			}

			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}


