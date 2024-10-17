package 유형.그리디.기타줄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int pack = Integer.MAX_VALUE;
			int single = Integer.MAX_VALUE;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				pack = Math.min(pack, Integer.parseInt(st.nextToken()));
				single = Math.min(single, Integer.parseInt(st.nextToken()));
			}
			pack = Math.min(pack, single * 6);

			System.out.println(Math.min(n / 6 * pack + n % 6 * single, (n / 6 + 1) * pack));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
