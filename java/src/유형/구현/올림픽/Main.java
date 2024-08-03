package 유형.구현.올림픽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n + 1][3];
			for (int i = 0; i < n; i++) {
				int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				arr[temp[0]][0] = temp[1];
				arr[temp[0]][1] = temp[2];
				arr[temp[0]][2] = temp[3];
			}

			int rank = 1;
			for (int i = 1; i <= n; i++) {
				if (i == k) {
					continue;
				}
				if (arr[i][0] > arr[k][0]) {
					rank++;
				} else if (arr[i][0] == arr[k][0] && arr[i][1] > arr[k][1]) {
					rank++;
				} else if (arr[i][0] == arr[k][0] && arr[i][1] == arr[k][1] && arr[i][2] > arr[k][2]) {
					rank++;
				}
			}

			System.out.println(rank);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
