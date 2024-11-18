package 유형.구현.울음;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());

			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				t -= Integer.parseInt(st.nextToken());
			}

			if (t > 0) {
				System.out.println("Padaeng_i Cry");
			} else {
				System.out.println("Padaeng_i Happy");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
