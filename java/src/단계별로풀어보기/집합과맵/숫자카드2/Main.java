package 단계별로풀어보기.집합과맵.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			HashMap<String, Integer> map = new HashMap<>();
			StringBuffer result = new StringBuffer();


			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String num = st.nextToken(" ");
				map.put(num, map.getOrDefault(num, 0) + 1);
			}

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				String num = st.nextToken(" ");
				result.append(map.getOrDefault(num, 0));
				result.append(" ");
			}

			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
