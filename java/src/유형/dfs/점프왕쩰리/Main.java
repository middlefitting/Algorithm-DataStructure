package 유형.dfs.점프왕쩰리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n;
	static int[][] arr;

	static boolean[][] v;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			v = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			if (dfs(0, 0)) {
				System.out.println("HaruHaru");
			} else {
				System.out.println("Hing");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static boolean dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= n || v[i][j]) {
			return false;
		}

		v[i][j] = true;

		if (i == n - 1 && j == n - 1) {
			return true;
		}
		int mv = arr[i][j];
		return dfs(i + mv, j) || dfs(i, j + mv);
	}
}
