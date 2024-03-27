package 유형.백트레킹.카드놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	private static int n;
	private static int k;
	private static String[] cards;
	private static HashSet<String> answers = new HashSet<>();
	private static boolean[] v;

	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			k = Integer.parseInt(br.readLine());
			cards = new String[n];
			for (int i = 0; i < n; i++) {
				cards[i] = br.readLine();
			}
			v = new boolean[n];
			dfs(0, "");
			System.out.println(answers.size());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static void dfs(int depth, String temp) {
		if (depth == k) {
			answers.add(temp);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				dfs(depth + 1, temp + cards[i]);
				v[i] = false;
			}
		}
	}
}
