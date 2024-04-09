package 알고리즘.easy.sitescore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer sb = new StringTokenizer(br.readLine());
			int answer = 0;
			answer +=
				56 * Integer.parseInt(sb.nextToken()) + 24 * Integer.parseInt(sb.nextToken()) + 14 * Integer.parseInt(
					sb.nextToken()) + 6 * Integer.parseInt(sb.nextToken());
			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
