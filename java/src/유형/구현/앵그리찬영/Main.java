package 유형.구현.앵그리찬영;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());

			StringBuilder sb = new StringBuilder();

			double size = Math.sqrt(a * a + b * b);
			for (int i = 0; i < n; i++) {
				double temp = Double.parseDouble(br.readLine());

				if (temp > size) {
					sb.append("NE").append("\n");
				} else {
					sb.append("DA").append("\n");
				}
			}

			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
