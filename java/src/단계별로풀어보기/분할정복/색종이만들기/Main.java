package 단계별로풀어보기.분할정복.색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	private static int white = 0;
	private static int blue = 0;
	static boolean[][] arr;

	private static void dfs(int xs, int xe, int ys, int ye) {
		boolean temp = arr[xs][ys];
		for (int i = xs; i < xe; i++) {
			for (int j = ys; j < ye; j++) {
				if (arr[i][j] != temp) {
					dfs(xs, xe - (xe - xs) / 2, ys, ye - (ye - ys) / 2);
					dfs(xs + (xe - xs) / 2, xe, ys, ye - (ye - ys) / 2);
					dfs(xs, xe - (xe - xs) / 2, ys + (ye - ys) / 2, ye);
					dfs(xs + (xe - xs) / 2, xe, ys + (ye - ys) / 2, ye);
					return;
				}
			}
		}
		if (temp == false) {
			white++;
		} else {
			blue++;
		}
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			arr = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				List<Boolean> temp = Stream.of(br.readLine().split(" "))
					.map((s) -> s.equals("1"))
					.collect(Collectors.toList());
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp.get(j);
				}
			}
			dfs(0, n, 0, n);
			System.out.println(white);
			System.out.println(blue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
