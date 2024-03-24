package 알고리즘.easy.Identifyingtea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				if (Integer.parseInt(st.nextToken()) == n) {
					answer++;
				}
			}
			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
