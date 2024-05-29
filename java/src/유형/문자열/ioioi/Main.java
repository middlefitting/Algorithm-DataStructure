package 유형.문자열.ioioi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			Map<Integer, Integer> map = new HashMap<>();
			String str = br.readLine();
			char[] arr = str.toCharArray();

			int s = -1;
			int e = -1;
			for (int i = 0; i < m; i++) {
				if (s == - 1) {
					if (arr[i] == 'I') {
						s = i;
						e = i;
					}
				} else {
					if (i < (m - 1) && arr[i] == 'O' && arr[i + 1] == 'I') {
						e++;
						i++;
					} else {
						map.put(e - s, map.getOrDefault(e - s, 0) + 1);
						s = -1;
						e = -1;
						if (arr[i] == 'I') {
							s = i;
							e = i;
						}
					}
				}
			}
			if (s != -1) {
				map.put(e - s, map.getOrDefault(e - s, 0) + 1);
			}

			int result = 0;
			for (int key : map.keySet()) {
				if (key >= n) {
					result += map.get(key) * (key - n + 1);
				}
			}
			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
