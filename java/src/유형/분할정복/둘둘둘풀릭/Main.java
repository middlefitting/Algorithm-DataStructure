package 유형.분할정복.둘둘둘풀릭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			int[][] pre = arr;
			while (n > 1) {
				n /= 2;
				int[][] next = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						next[i][j] = getSecond(pre, i, j);
					}
				}
				pre = next;
			}
			System.out.println(pre[0][0]);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int getSecond(int[][] pre, int i, int j) {
		int[] nums = new int[4];
		int idx = 0;
		for (int x = i * 2; x < i * 2 + 2; x++) {
			for (int y = j * 2; y < j * 2 + 2; y++) {
				nums[idx] = pre[x][y];
				idx++;
			}
		}
		Arrays.sort(nums);
		return nums[2];
	}
}

