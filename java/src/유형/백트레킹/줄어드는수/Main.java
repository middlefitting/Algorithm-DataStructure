package 유형.백트레킹.줄어드는수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	private static int n;
	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		ArrayList<String> answers = new ArrayList<>();
		ArrayList<ArrayList<ArrayList<String>>> info = new ArrayList<>();
		info.add(new ArrayList<>());
		for (int i = 0; i <= 9; i++) {
			info.get(0).add(new ArrayList<>());
			info.get(0).get(i).add(String.valueOf(i));
			answers.add(String.valueOf(i));
		}

		int fIdx = 0;
		while (fIdx < 10) {
			fIdx++;
			info.add(new ArrayList<>());
			for (int i = 0; i <= 9; i++) {
				info.get(fIdx).add(new ArrayList<>());
			}

			for (int i = fIdx; i <= 9; i++) {
				for (int j = 0; j < i; j++) {
					for (String num : info.get(fIdx - 1).get(j)) {
						String temp = i + num;
						info.get(fIdx).get(i).add(temp);
						answers.add(temp);
					}
				}

			}
		}
		if (answers.size() < n) {
			System.out.println(-1);
		} else {
			System.out.println(answers.get(n - 1));
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
