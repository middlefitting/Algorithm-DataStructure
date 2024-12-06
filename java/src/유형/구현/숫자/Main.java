package 유형.구현.숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long s = Long.parseLong(st.nextToken());
			long e = Long.parseLong(st.nextToken());

			if (s > e) {
				long temp = s;
				s = e;
				e = temp;
			}
			System.out.println(Math.max(e - s - 1, 0));

			StringBuilder sb = new StringBuilder();
			for (long i = s + 1; i < e; i++) {
				if (i != (s + 1)) {
					sb.append(" ");
				}
				sb.append(i);
			}

			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
