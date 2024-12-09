package 유형.해시.cd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());

				if (n == 0 && m == 0) {
					break;
				}
				HashSet<Integer> set = new HashSet<>();
				for (int i = 0; i < n; i++) {
					set.add(Integer.parseInt(br.readLine()));
				}

				int result = 0;
				for (int i = 0; i < m; i++) {
					if (set.contains(Integer.parseInt(br.readLine()))) {
						result++;
					}
				}
				System.out.println(result);
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
