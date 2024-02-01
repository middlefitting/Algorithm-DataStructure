package 단계별로풀어보기.집합과맵.나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken(" "));
			int m = Integer.parseInt(st.nextToken());
			HashMap<String, String> map = new HashMap<>();

			for (int i = 1; i <= n; i++) {
				String value = br.readLine();
				String idx = String.valueOf(i);
				map.put(value, idx);
				map.put(idx, value);
			}

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < m; i++) {
				sb.append(map.get(br.readLine()));
				sb.append("\n");
			}

			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
