package 알고리즘.easy.단순한문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int result = 0;
				for (int x = 1; x <= a; x++) {
					for (int y = 1; y <= b; y++) {
						for (int z = 1; z <= c; z++) {
							int a1 = x % y;
							int a2 = y % z;
							int a3 = z % x;
							if (a1 == a2 && a2 == a3) {
								result++;
							}
						}
					}
				}
				System.out.println(result);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
