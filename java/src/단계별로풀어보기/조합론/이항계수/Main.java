package 단계별로풀어보기.조합론.이항계수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int answer = n;
			for (int i = 1; i < m; i++) {
				answer *= (n - i);
				answer /= (i + 1);
			}
			if (m != 0) {
				System.out.println(answer);
			} else {
				System.out.println(1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
