package 알고리즘.easy.민주주의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int answer = 0;
			for (int i = 0; i < n; i++) {
				long cnt = Stream.of(br.readLine().split(""))
					.filter((c) -> c.equals("O"))
					.count();
				if (cnt > m / 2) {
					answer += 1;
				}
			}
			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
