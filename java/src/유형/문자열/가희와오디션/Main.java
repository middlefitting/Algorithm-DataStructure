package 유형.문자열.가희와오디션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			if (s.equals("miss")) {
				System.out.println(0);
			} else if (s.equals("bad")) {
				System.out.println(n * 200);
			} else if (s.equals("cool")) {
				System.out.println(n * 400);
			} else if (s.equals("great")) {
				System.out.println(n * 600);
			} else if (s.equals("perfect")) {
				System.out.println(n * 1000);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
