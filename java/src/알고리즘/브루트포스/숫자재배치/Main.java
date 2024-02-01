package 알고리즘.브루트포스.숫자재배치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Reader {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static ArrayList<String> readToStringArr() {
		try {
			return
				Stream.of(br.readLine().split(" "))
					.collect(Collectors.toCollection(ArrayList::new));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}

class Game {
	private int[] split;
	private boolean[] v;
	private int b;
	private int aLen;
	private int answer;

	public Game(ArrayList<String> args) {
		b = Integer.parseInt(args.get(1));
		aLen = args.get(0).length();
		answer = -1;

		split = Stream.of(args.get(0).split(""))
			.mapToInt(Integer::parseInt)
			.toArray();

		v = new boolean[split.length];
		dfs(0, 0);
	}

	void dfs(int temp, int depth) {
		if (depth == aLen && temp < b) {
			answer = Math.max(answer, temp);
		}
		for (int i = 0; i < aLen; i++) {
			if (!v[i] && (depth != 0 || split[i] != 0)) {
				v[i] = true;
				dfs(temp * 10 + split[i], depth + 1);
				v[i] = false;
			}
		}

	}

	int getAnswer() {
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		System.out.println(new Game(Reader.readToStringArr()).getAnswer());
	}
}

