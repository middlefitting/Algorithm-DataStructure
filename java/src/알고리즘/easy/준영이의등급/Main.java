package 알고리즘.easy.준영이의등급;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < k; i++) {
				int grade = Integer.parseInt(st.nextToken());
				sb.append(calc(n, grade)).append(" ");
			}
			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int calc(int n, int grade) {
		int result = grade * 100 / n;
		if (result <= 4) {
			return 1;
		} else if (result <= 11) {
			return 2;
		} else if (result <= 23) {
			return 3;
		} else if (result <= 40) {
			return 4;
		} else if (result <= 60) {
			return 5;
		} else if (result <= 77) {
			return 6;
		} else if (result <= 89) {
			return 7;
		} else if (result <= 96) {
			return 8;
		}
		return 9;
	}
}
