package 유형.구현.직사각형에서탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			// 6 2 10 3

			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int result = Math.min(a, b);
			result = Math.min(result, c - a);
			result = Math.min(result, d - b);
			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
