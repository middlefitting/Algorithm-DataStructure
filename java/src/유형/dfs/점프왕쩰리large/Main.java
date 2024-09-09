package 유형.dfs.점프왕쩰리large;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int[][] mvs = {{1, 0}, {0, 1}};

	public static void main(String[] args) {
		logic(parse());
	}

	private static void logic(Data data) {
		dfs(0, 0, data);
		if (data.result) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}

	private static void dfs(int x, int y, Data data) {
		if (data.arr[x][y] == -1) {
			data.result = true;
		}
		for (int[] mv : mvs) {
			int tx = mv[0] * data.arr[x][y] + x;
			int ty = mv[1] * data.arr[x][y] + y;
			if (tx < 0 || ty < 0 || tx >= data.n || ty >= data.m) {
				continue;
			}
			if (data.v[tx][ty]) {
				continue;
			}
			data.v[tx][ty] = true;
			dfs(tx, ty, data);
		}
	}

	private static Data parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Data data = new Data(Integer.parseInt(st.nextToken()));
			for (int i = 0; i < data.n; i++) {
				data.arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			return data;
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Data {
		int n;
		int m;
		int[][] arr;
		boolean[][] v;
		boolean result;

		public Data(int n) {
			this.n = n;
			this.m = n;
			this.arr = new int[n][m];
			this.v = new boolean[n][m];
		}
	}
}
