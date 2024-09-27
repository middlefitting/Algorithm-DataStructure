package 유형.그래프.파이프옮기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int result = 0;
	static int[][] arr;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			dfs(0, 1, Position.RIGHT);
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static void dfs(int x, int y, Position position) {
		if (x == n - 1 && y == n - 1) {
			result++;
			return;
		}
		if (movePossible(x, y + 1, position, Position.DOWN)) {
			dfs(x, y + 1, Position.RIGHT);
		}
		if (movePossible(x + 1, y, position, Position.RIGHT)) {
			dfs(x + 1, y, Position.DOWN);
		}
		if (movePossible(x + 1, y + 1, position, null)) {
			dfs(x + 1, y + 1, Position.DIAGONAL);
		}
	}

	private static boolean movePossible(int x, int y, Position position, Position impossiblePosition) {
		if (position == impossiblePosition) {
			return false;
		}
		if (x >= n || y >= n) {
			return false;
		}
		if (arr[x][y] == 1) {
			return false;
		}

		if (impossiblePosition == null) {
			if (arr[x - 1][y] == 1 || arr[x][y - 1] == 1) {
				return false;
			}
		}
		return true;
	}

	enum Position {
		RIGHT,
		DOWN,
		DIAGONAL,
		NONE;
	}
}
