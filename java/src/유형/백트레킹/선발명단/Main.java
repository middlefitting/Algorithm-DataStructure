package 유형.백트레킹.선발명단;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	private static int[][] players = new int[11][11];
	private static int answer;

	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int t = 0; t < n; t++) {
				StringTokenizer st;
				for (int i = 0; i < 11; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j = 0; j < 11; j++) {
						players[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				HashSet set = new HashSet();
				dfs(0, set, 0);
				System.out.println(answer);
				answer = 0;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void dfs(int depth, HashSet set, int score) {
		if (depth == 11) {
			answer = Math.max(answer, score);
			return;
		}
		for (int i = 0; i < 11; i++) {
			if (players[depth][i] != 0 && !set.contains(i)) {
				set.add(i);
				score += players[depth][i];
				dfs(depth + 1, set, score);
				set.remove(i);
				score -= players[depth][i];
			}
		}
	}
}
