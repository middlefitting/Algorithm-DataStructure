package 단계별로풀어보기.집합과맵.문자열집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken(" "));
			int m = Integer.parseInt(st.nextToken());
			int answer = 0;
			HashSet<String> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				set.add(br.readLine());
			}
			for (int j = 0; j < m; j++) {
				if (set.contains(br.readLine())) {
					answer += 1;
				}
			}
			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
