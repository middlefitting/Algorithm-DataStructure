package 유형.문자열.알파벳거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append("Distances: ");
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				for (int j = 0; j < a.length(); j++) {
					int temp = b.charAt(j) - a.charAt(j);
					if (temp < 0) {
						temp += 26;
					}
					sb.append(temp);
					sb.append(" ");
				}
				System.out.println(sb);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
