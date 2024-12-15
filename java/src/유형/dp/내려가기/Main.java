package 유형.dp.내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			int[][] maxArr = new int[n][3];
			int[][] minArr = new int[n][3];
			int[][] arr = new int[n][3];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}

			maxArr[0][0] = arr[0][0];
			maxArr[0][1] = arr[0][1];
			maxArr[0][2] = arr[0][2];

			minArr[0][0] = arr[0][0];
			minArr[0][1] = arr[0][1];
			minArr[0][2] = arr[0][2];

			for (int i = 1; i < n; i++) {

				maxArr[i][0] = Math.max(maxArr[i - 1][0], maxArr[i - 1][1]) + arr[i][0];
				maxArr[i][1] = Math.max(Math.max(maxArr[i - 1][0], maxArr[i - 1][1]), maxArr[i - 1][2]) + arr[i][1];
				maxArr[i][2] = Math.max(maxArr[i - 1][1], maxArr[i - 1][2]) + arr[i][2];

				minArr[i][0] = Math.min(minArr[i - 1][0], minArr[i - 1][1]) + arr[i][0];
				minArr[i][1] = Math.min(Math.min(minArr[i - 1][0], minArr[i - 1][1]), minArr[i - 1][2]) + arr[i][1];
				minArr[i][2] = Math.min(minArr[i - 1][1], minArr[i - 1][2]) + arr[i][2];
			}

			Arrays.sort(maxArr[n - 1]);
			Arrays.sort(minArr[n - 1]);

			System.out.println(maxArr[n - 1][2] + " " + minArr[n - 1][0]);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
