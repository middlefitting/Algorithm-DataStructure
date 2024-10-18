package 유형.해시.임스와함께하는미니게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String game = st.nextToken();
			int need = 0;
			if (game.equals("Y")) {
				need = 1;
			}
			if (game.equals("F")) {
				need = 2;
			}
			if (game.equals("O")) {
				need = 3;
			}
			HashSet<String> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				set.add(br.readLine());
			}
			System.out.println(set.size() / need);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
