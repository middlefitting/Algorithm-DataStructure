package 유형.사칙연산.피로도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int a;
	private static int b;
	private static int c;
	private static int m;

	public static void main(String[] args) {
		parse();
		calcAnswer();
	}

	private static void calcAnswer() {
		int answer = 0;
		int tired = 0;
		for (int i = 0; i < 24; i++) {
			if (tired + a <= m) {
				tired += a;
				answer += b;
			} else {
				tired = Math.max(0, tired - c);
			}
		}
		System.out.println(answer);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
