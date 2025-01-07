package 유형.구현.쿠폰;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				double num = Double.parseDouble(br.readLine());
				num *= 0.8;
				sb.append("$").append(String.format("%.2f", Math.round(num * 100.0) / 100.0)).append("\n");
			}

			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
