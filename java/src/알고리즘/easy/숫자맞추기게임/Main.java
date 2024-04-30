package 알고리즘.easy.숫자맞추기게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuffer sb = new StringBuffer();
			int cnt = 0;
			while (true) {
				cnt++;
				int n = Integer.parseInt(br.readLine());
				if (n == 0) {
					break;
				}
				sb.append(cnt).append(". ");
				if (n % 2 == 0) {
					sb.append("even ").append(n / 2).append("\n");
				} else {
					sb.append("odd ").append(n / 2).append("\n");
				}
			}
			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
