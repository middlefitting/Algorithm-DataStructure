package 유형.구현.제안;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) - 1;

			int result = a;
			if (b > 0) {
				result += (a / b);
				if (a % b != 0) {
					result++;
				}
				System.out.println(result);
			} else {
				System.out.println(-1);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
