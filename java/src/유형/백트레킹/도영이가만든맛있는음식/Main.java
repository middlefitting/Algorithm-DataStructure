package 유형.백트레킹.도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	private static int answer = Integer.MAX_VALUE;
	private static int n;
	private static int[][] foods;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			foods = new int[n][2];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				foods[i][0] =Integer.parseInt(st.nextToken());
				foods[i][1] =Integer.parseInt(st.nextToken());
			}
			dfs(0, new LinkedList<>());
			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void dfs(int s, LinkedList<Integer> selectFoods) {
		if (selectFoods.size() != 0) {
			answer = Math.min(calcResult(selectFoods), answer);
		}
		if (s == n) {
			return;
		}
		for (int i = s; i < n; i++) {
			selectFoods.add(i);
			dfs(i + 1, selectFoods);
			selectFoods.removeLast();
		}
	}

	private static int  calcResult(LinkedList<Integer> selectFoods) {
		int sour = foods[selectFoods.get(0)][0];
		int dark = foods[selectFoods.get(0)][1];
		for (int i = 1; i < selectFoods.size(); i++) {
			sour *= foods[selectFoods.get(i)][0];
			dark += foods[selectFoods.get(i)][1];
		}
		return Math.abs(sour - dark);
	}
}
