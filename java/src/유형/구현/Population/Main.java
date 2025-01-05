package 유형.구현.Population;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int now = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				now += (time / 4);
				now -= (time / 7);

				sb.append(now).append("\n");
			}

			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
