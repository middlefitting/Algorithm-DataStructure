package 알고리즘.easy.별찍기16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 1; i <= n; i++) {
				System.out.println(" ".repeat(n - i) + "* ".repeat(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
