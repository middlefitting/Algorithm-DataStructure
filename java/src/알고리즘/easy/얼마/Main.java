package 알고리즘.easy.얼마;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				int amount = Integer.parseInt(br.readLine());
				int k = Integer.parseInt(br.readLine());
				for (int j = 0; j < k; j++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					amount += a * b;
				}
				System.out.println(amount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
