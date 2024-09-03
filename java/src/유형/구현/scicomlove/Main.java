package 유형.구현.scicomlove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append("SciComLove\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
