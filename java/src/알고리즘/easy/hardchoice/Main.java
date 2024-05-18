package 알고리즘.easy.hardchoice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			System.out.println(calc(a, d) + calc(b, e) + calc(c, f));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int calc(int a, int b) {
		return Math.min(0, a - b) * -1;
	}
}
