package 알고리즘.easy.수학적호기심;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int answer = 0;
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				for (int a = 1; a < n; a++) {
					for (int b = a + 1; b < n; b++) {
						if ((a * a + b * b + m) % (a * b) == 0) {
							answer++;
						}
					}
				}
				System.out.println(answer);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
