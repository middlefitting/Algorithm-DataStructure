package 유형.구현.탄산음료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int have = Integer.parseInt(st.nextToken());
			int find = Integer.parseInt(st.nextToken());
			int need = Integer.parseInt(st.nextToken());

			have += find;

			int result = 0;
			while (have >= need) {
				result++;
				have -= need;
				have++;
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
