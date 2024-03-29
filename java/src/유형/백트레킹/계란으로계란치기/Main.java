package 유형.백트레킹.계란으로계란치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int answer;
	private static Egg[] eggs;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int depth, int cnt) {
		if (depth == n) {
			answer = Math.max(answer, cnt);
			return;
		}
		if (eggs[depth].isBreak()) {
			dfs(depth + 1, cnt);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (i != depth && !eggs[i].isBreak()) {
				eggs[depth].attack(eggs[i]);
				int temp = 0;
				if (eggs[depth].isBreak()) {
					temp++;
				}
				if (eggs[i].isBreak()) {
					temp++;
				}
				dfs(depth + 1, cnt + temp);
				eggs[depth].recover(eggs[i]);
			}
		}
		if (cnt == n - 1) {
			dfs(depth + 1, cnt);
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			eggs = new Egg[n];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st  = new StringTokenizer(br.readLine());
				eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	static class Egg {
		int weight;
		int life;

		Egg(int life, int weight) {
			this.life = life;
			this.weight = weight;
		}

		boolean isBreak() {
			return life <= 0;
		}

		void attack(Egg target) {
			this.life -= target.weight;
			target.life -= this.weight;
		}

		void recover(Egg target) {
			this.life += target.weight;
			target.life += this.weight;
		}
	}
}
