package 유형.브루트포스.토너먼트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int round = 0;
			while (true) {
				round++;
				a = a / 2 + a % 2;
				b = b / 2 + b % 2;
				if (a == b) {
					break;
				}
			}
			System.out.println(round);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
