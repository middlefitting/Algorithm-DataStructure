package 유형.구현.sort마스터후계자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			HashMap<Integer, Integer> map = new HashMap<>();

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(br.readLine());
				arr[i] = num;
			}
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				int num = arr[i];
				if (!map.containsKey(num)) {
					map.put(num, i);
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(map.getOrDefault(Integer.parseInt(br.readLine()), -1)).append("\n");
			}

			System.out.println(sb);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
