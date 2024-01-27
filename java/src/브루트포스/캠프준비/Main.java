package 브루트포스.캠프준비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Reader {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private Reader() {
		throw new RuntimeException();
	}

	public static ArrayList<Integer> readInteger() {
		try {
			return
				Arrays.stream(br.readLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toCollection(ArrayList::new));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}

class Camp {
	int N;
	int L;
	int R;
	int X;
	int answer;
	ArrayList<Integer> problems;

	public Camp(ArrayList<Integer> arguments, ArrayList<Integer> problems) {
		this.N = arguments.get(0);
		this.L = arguments.get(1);
		this.R = arguments.get(2);
		this.X = arguments.get(3);
		this.problems = problems;
		dfs(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private void dfs(int idx, int depth, int sum, int min, int max) {
		if (sum > R)
			return;

		if (depth >= 2 && sum >= L && max - min >= X) {
			answer += 1;
		}
		for (int i = idx; i < N; i++) {
			int x = problems.get(i);
			dfs(i + 1, depth + 1, sum + x, Math.min(min, x), Math.max(max, x));
		}
	}

	public int getAnswer() {
		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arguments = Reader.readInteger();
		ArrayList<Integer> problems = Reader.readInteger();
		Camp camp = new Camp(arguments, problems);
		System.out.println(camp.getAnswer());
	}
}
