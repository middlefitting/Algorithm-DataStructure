package 유형.해시.전쟁땅따먹기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());

				HashMap<Integer, Integer> map = new HashMap<>();
				boolean flag = false;
				int answer = 0;
				for (int j = 0; j < n; j++) {
					int soldier = Integer.parseInt(st.nextToken());
					map.put(soldier, map.getOrDefault(soldier, 0) + 1);
					if (map.get(soldier) > n / 2) {
						flag = true;
						answer = soldier;
					}
				}

				if (flag) {
					System.out.println(answer);
				} else {
					System.out.println("SYJKGW");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
