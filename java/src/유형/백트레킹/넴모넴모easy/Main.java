package 유형.백트레킹.넴모넴모easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static boolean arr[][];
	private static int answer;
	private static int[][] moves = {{0, -1}, {-1, 0}, {-1, -1}};

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		arr = new boolean[n][m];
		dfs(0);
		System.out.println(answer);
	}

	private static void dfs(int depth) {
		if (depth == n * m) {
			answer++;
			return;
		}
		int x = depth / m;
		int y = depth % m;
		boolean flag = false;
		for (int[] move : moves) {
			int tx = move[0] + x;
			int ty = move[1] + y;
			if (tx < 0 || ty < 0) {
				flag = true;
				continue;
			}
			if (!arr[tx][ty]) {
				flag = true;
			}
		}
		dfs(depth + 1);
		if (flag) {
			arr[x][y] = true;
			dfs(depth + 1);
			arr[x][y] = false;
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
