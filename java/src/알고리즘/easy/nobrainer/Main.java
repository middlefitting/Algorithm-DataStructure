package 알고리즘.easy.nobrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (a >= b) {
					System.out.println("MMM BRAINS");
				} else {
					System.out.println("NO BRAINS");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
