package 유형.해시.빈도정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			TreeMap<Integer, Integer> map = new TreeMap<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(st.nextToken());
				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				for (int i = 0; i < entry.getValue(); i++) {
					System.out.print(entry.getKey());
					System.out.print(" ");
				}
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
