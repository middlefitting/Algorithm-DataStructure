package 단계별로풀어보기.분할정복.행렬곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	private static int[][] readMatrix(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < m; j++) {
				matrix[i][j] = arr[j];
			}
		}
		return matrix;
	}

	private static int[][] multiMatrix(int[][] a, int[][] b) {
		int n = a.length;
		int m = b[0].length;
		int k = a[0].length;
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int x = 0; x < k; x++) {
					result[i][j] += a[i][x] * b[x][j];
				}
			}
		}
		return result;
	}

	private static StringBuffer matrixToStringBuffer(int[][] matrix) {
		StringBuffer result = new StringBuffer();
		Arrays.stream(matrix)
			.forEach((arr) -> {
				Arrays.stream(arr).forEach((i) -> result.append(i).append(" "));
				result.setLength(result.length() - 1);
				result.append("\n");
			});
		return result;
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int[][] a = readMatrix(br);
			int[][] b = readMatrix(br);
			int[][] answer = multiMatrix(a, b);
			System.out.print(matrixToStringBuffer(answer));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
