package 유형.구현.cookiefiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());

			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				int result = 0;
				for (int j = 0; j < a; j++) {
					result += b + c * j;
				}

				System.out.println(result);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
