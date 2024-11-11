package 유형.구현.꼬리를무는문자나열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int diff = Math.abs((a % 4 == 0 ? 4 : a % 4) - (b % 4 == 0 ? 4 : b % 4));
			a = a + (4 - (a % 4 == 0 ? 4 : a % 4));
			b = b + (4 - (b % 4 == 0 ? 4 : b % 4));
			diff += Math.abs(a / 4 - b / 4);
			System.out.println(diff);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
