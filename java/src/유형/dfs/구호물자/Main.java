package 유형.dfs.구호물자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Data data = parse();
		logic(data);
	}

	private static void logic(Data data) {
		data.visitLine = new boolean[data.n + 1][data.n + 1];
		data.v = new boolean[data.n + 1];
		dfs(1, data);
		if (data.isCycle) {
			System.out.println("CYCLE");
		} else {
			System.out.println("NO CYCLE");
		}
	}

	private static void dfs(int x, Data data) {
		if (data.isCycle) {
			return;
		}
		if (!data.v[x]) {
			data.v[x] = true;
		} else {
			data.isCycle = true;
		}
		// if (x == data.n) {
		// 	if (cycle) {
		// 		data.isCycle = true;
		// 	}
		// }

		for (int y : data.vec[x]) {
			if (!data.visitLine[x][y]) {
				data.visitLine[x][y] = true;
				dfs(y, data);
				data.visitLine[x][y] = false;
			}
		}

		data.v[x] = false;
	}

	private static Data parse() {
		Data data = new Data();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			data.n = Integer.parseInt(br.readLine());
			data.vec = new LinkedList[data.n + 1];
			for (int i = 0; i <= data.n; i++) {
				data.vec[i] = new LinkedList<>();
			}

			for (int i = 1; i < data.n; i++) {
				int s = Integer.parseInt(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine());
				while (--s >= 0) {
					data.vec[i].add(Integer.parseInt(st.nextToken()));
				}
			}

			return data;

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Data {
		int n;
		LinkedList<Integer>[] vec;
		boolean[][] visitLine;
		boolean[] v;
		boolean isCycle;
	}
}
