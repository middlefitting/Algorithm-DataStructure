package 유형.백트레킹.감소하는수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static int n;
	private static List<Long> answers = new ArrayList<>();

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i <= 9; i++) {
				temp.add(i);
				dfs(0, temp);
				temp.remove(0);
			}
			answers = answers.stream().sorted().collect(Collectors.toList());
			if (answers.size() < n + 1) {
				System.out.println(-1);
			} else {
				System.out.println(answers.get(n));
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void dfs(int depth, List<Integer> temp) {
		StringBuffer sb = new StringBuffer();
		for (Integer num : temp) {
			sb.append(num);
		}
		answers.add(Long.parseLong(sb.toString()));

		for (int i = 0; i < temp.get(depth); i++) {
			temp.add(i);
			dfs(depth + 1, temp);
			temp.remove(depth + 1);
		}
	}
}
