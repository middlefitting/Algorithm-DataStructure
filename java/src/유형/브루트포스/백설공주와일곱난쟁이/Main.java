package 유형.브루트포스.백설공주와일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
	static int[] arr;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			arr = new int[9];
			for (int i = 0; i < 9; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}

			brute(0, 0, new LinkedList<>());
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void brute(int idx, int depth, LinkedList<Integer> answers) {
		int sum = answers.stream().mapToInt((i) -> i).sum();
		if (sum == 100  && depth == 7) {
			System.out.print(answers.stream().map(String::valueOf).collect(Collectors.joining("\n")));
			System.exit(0);
		}
		if (idx >= 9) {
			return;
		}
		answers.addLast(arr[idx]);
		brute(idx + 1, depth + 1, answers);
		answers.removeLast();
		brute(idx + 1, depth, answers);
	}
}

