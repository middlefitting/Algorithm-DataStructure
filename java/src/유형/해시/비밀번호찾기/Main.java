package 유형.해시.비밀번호찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			HashMap<String, String> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				map.put(st.nextToken(), st.nextToken());
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(map.get(br.readLine())).append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
