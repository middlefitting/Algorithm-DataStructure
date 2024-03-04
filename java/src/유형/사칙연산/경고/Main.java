package 유형.사칙연산.경고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] before = new int[3];
	private static int[] after = new int[3];

	private static int[] result = new int[3];

	public static void main(String[] args) {
		parse();
		for (int i = 0; i < 3; i++) {
			result[i] = after[i] - before[i];
		}
		while (result[2] < 0) {
			result[2] += 60;
			result[1] -= 1;
		}
		while (result[1] < 0) {
			result[1] += 60;
			result[0] -= 1;
		}
		while (result[0] < 0) {
			result[0] += 24;
		}
		StringBuffer answer = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			if (result[i] < 10) {
				answer.append("0");
			}
			answer.append(result[i]);
			if (i != 2) {
				answer.append(":");
			}
		}
		if (Arrays.stream(result).sum() == 0) {
			System.out.println("24:00:00");
		} else {
			System.out.println(answer);
		}

	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				before[i] = Integer.parseInt(st.nextToken(":"));
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				after[i] = Integer.parseInt(st.nextToken(":"));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
