package 유형.구현.pizza;

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
				double a = Double.parseDouble(st.nextToken());
				double aPrice = Double.parseDouble(st.nextToken());

				st = new StringTokenizer(br.readLine());
				double b = Double.parseDouble(st.nextToken());
				double bPrice = Double.parseDouble(st.nextToken());

				double circle = b * b * Math.PI;
				if (a / aPrice < circle / bPrice) {

					sb.append("Whole pizza\n");
				} else {

					sb.append("Slice of pizza\n");
				}
			}

			System.out.print(sb);


		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
