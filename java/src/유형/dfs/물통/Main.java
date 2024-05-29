package 유형.dfs.물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	private static int limitA;
	private static int limitB;
	private static int limitC;
	private static HashSet<String> dp = new HashSet<>();
	private static HashSet<Integer> answers = new HashSet<>();

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			limitA = Integer.parseInt(st.nextToken());
			limitB = Integer.parseInt(st.nextToken());
			limitC = Integer.parseInt(st.nextToken());

			dfs(0, 0, limitC);

			List<Integer> results = answers.stream().sorted().collect(Collectors.toList());
			StringBuilder sb = new StringBuilder();
			for (Integer result : results) {
				sb.append(result).append(" ");
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static void dfs(int a, int b, int c) {
		if (dp.contains(a + "%" + b + "%" + c)) {
			return;
		}
		dp.add(a + "%" + b + "%" + c);
		if (a == 0) {
			answers.add(c);
		}

		dfs(a - Math.min(a, limitB - b), b + Math.min(a, limitB - b), c);
		dfs(a - Math.min(a, limitC - c), b, c + Math.min(a, limitC - c));

		dfs(a + Math.min(b, limitA - a), b - Math.min(b, limitA - a), c);
		dfs(a, b - Math.min(b, limitC - c), c + Math.min(b, limitC - c));

		dfs(a, b + Math.min(c, limitB - b), c - Math.min(c, limitB - b));
		dfs(a + Math.min(c, limitA - a), b, c - Math.min(c, limitA - a));
	}
}
