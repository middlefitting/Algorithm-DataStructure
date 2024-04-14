package 랜덤디팬스.실버.품질검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				n += Integer.parseInt(st.nextToken());
			}
			int k = Integer.parseInt(br.readLine());
			int[] result = new int[n + 1];
			Arrays.fill(result, 2);

			int[][] arr = new int[k][4];
			for (int i = 0; i < k; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			for (int i = 0; i < k; i++) {
				if (arr[i][3] == 1) {
					for (int j = 0; j < 3; j++) {
						result[arr[i][j]] = 1;
					}
				}
			}

			for (int i = 0; i < k; i++) {
				int target = 0;
				int cnt = 0;
				if (arr[i][3] == 0) {
					for (int j = 0; j < 3; j++) {
						if (result[arr[i][j]] != 1) {
							target = arr[i][j];
							cnt++;
						}
					}
					if (cnt == 1) {
						result[target] = 0;
					}
				}
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 1; i < n + 1; i++) {
				sb.append(result[i]).append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}

