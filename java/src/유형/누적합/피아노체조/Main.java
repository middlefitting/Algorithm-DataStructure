package 유형.누적합.피아노체조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] mistake = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				mistake[i] = mistake[i - 1];
				if (arr[Math.min(i, n - 1)] < arr[i - 1]) {
					mistake[i]++;
				}
			}

			StringBuffer answer = new StringBuffer();
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				answer.append(mistake[e - 1] - mistake[s - 1]).append("\n");
			}
			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
