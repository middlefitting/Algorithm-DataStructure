package 단계별로풀어보기.일반수학.중앙이동알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int answer = 4;
			int square = 1;
			for (int i = 1; i <= n; i++) {
				answer += Math.pow(4, i - 1) * 5 - ((Math.pow(2, i - 1) - 1) * Math.pow(2, i - 1) * 2);
				square += Math.pow(4, i);
			}
			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
