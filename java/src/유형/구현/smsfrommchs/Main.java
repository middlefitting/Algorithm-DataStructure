package 유형.구현.smsfrommchs;

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

			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (c < 0 && d >= 10) {
				System.out.println("A storm warning for tomorrow! Be careful and stay home if possible!");
			} else if (c < a) {
				System.out.println("MCHS warns! Low temperature is expected tomorrow.");
			} else if (d > b) {
				System.out.println("MCHS warns! Strong wind is expected tomorrow.");
			} else {
				System.out.println("No message");
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
