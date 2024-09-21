package 유형.브루트포스.foursquares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
//
// public class Main {
// 	static int answer = 0;
// 	static HashSet<String> set = new HashSet<>();
// 	static int[][] mvs = {{1, 0, 0, 0}, {1, 1, 0, 0}};
//
// 	public static void main(String[] args) {
// 		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
// 			int n = Integer.parseInt(br.readLine());
//
// 			track(n, 0);
//
// 			System.out.println(answer);
// 		} catch (IOException e) {
// 			throw new RuntimeException();
// 		}
// 	}
//
// 	private static void track(int n, int i) {
// 		set = new HashSet<>();
// 		dfs(1, n, new int[] {1});
// 		set = new HashSet<>();
// 		dfs(2, n, new int[] {1, 1});
// 		// set = new HashSet<>();
// 		dfs(3, n, new int[] {1, 1, 1});
// 		// set = new HashSet<>();
// 		dfs(4, n, new int[] {1, 1, 1, 1});
// 		// if (i > 3) {
// 		// 	return;
// 		// }
// 		// mvs[0][i] = 1;
// 		// track(n, i + 1);
// 		// mvs[0][i] = 0;
// 		// track(n, i + 1);
// 	}
//
// 	private static void dfs(int cnt, int target, int[] nums) {
// 		if (answer != 0) {
// 			return;
// 		}
// 		String s = "";
// 		for (int num : nums) {
// 			s += num;
// 		}
// 		if (set.contains(s)) {
// 			return;
// 		}
// 		set.add(s);
//
// 		int temp = 0;
// 		for (int num : nums) {
// 			temp += num * num;
// 		}
// 		if (temp > target) {
// 			return;
// 		} else if (temp == target) {
// 			answer = cnt;
// 			return;
// 		}
//
// 		for (int[] mv : mvs) {
// 			for (int i = 0; i < cnt; i++) {
// 				nums[i] += mv[i];
// 			}
// 			dfs(cnt, target, nums);
// 			for (int i = 0; i < cnt; i++) {
// 				nums[i] -= mv[i];
// 			}
// 		}
// 	}
// }
//
// //
// // public class Main {
// // 	static int answer = 0;
// // 	static HashSet<String> set = new HashSet<>();
// // 	static int[][] mvs = {{1, 0, 0, 0}, {1, 1, 0, 0}, {1, 1, 1, 0}, {1, 1, 1, 1}};
// //
// // 	public static void main(String[] args) {
// // 		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
// // 			int n = Integer.parseInt(br.readLine());
// //
// // 			dfs(1, n, new int[] {1});
// // 			dfs(2, n, new int[] {1, 1});
// // 			dfs(3, n, new int[] {1, 1, 1});
// // 			dfs(4, n, new int[] {1, 1, 1, 1});
// //
// // 			System.out.println(answer);
// // 		} catch (IOException e) {
// // 			throw new RuntimeException();
// // 		}
// // 	}
// //
// // 	private static void dfs(int cnt, int target, int[] nums) {
// // 		if (answer != 0) {
// // 			return;
// // 		}
// // 		String s = "";
// // 		for (int num : nums) {
// // 			s += num;
// // 		}
// // 		if (set.contains(s)) {
// // 			return;
// // 		}
// // 		set.add(s);
// //
// // 		int temp = 0;
// // 		for (int num : nums) {
// // 			temp += num * num;
// // 		}
// // 		if (temp > target) {
// // 			return;
// // 		} else if (temp == target) {
// // 			answer = cnt;
// // 			return;
// // 		}
// //
// // 		for (int[] mv : mvs) {
// // 			for (int i = 0; i < cnt; i++) {
// // 				nums[i] += mv[i];
// // 			}
// // 			dfs(cnt, target, nums);
// // 			for (int i = 0; i < cnt; i++) {
// // 				nums[i] -= mv[i];
// // 			}
// // 		}
// // 	}
// // }


// public class Main {
// 	public static void main(String[] args) {
// 		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
// 			int n = Integer.parseInt(br.readLine());
// 			int[] dp = new int[n + 1];
// 			Arrays.fill(dp, Integer.MAX_VALUE);
// 			dp[0] = 0;
//
// 			for (int i = 1; i * i <= n; i++) {
// 				int s = i * i;
// 				for (int j = s; j <= n; j++) {
// 					dp[j] = Math.min(dp[j], dp[j - s] + 1);
// 				}
// 			}
//
// 			System.out.println(dp[n]);
// 		} catch (IOException e) {
// 			throw new RuntimeException(e);
// 		}
// 	}
// }


public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				dp[i] = i;
			}


			for (int i = 1; i <= Math.sqrt(n); i++) {
				int s = i * i;
				for (int j = s; j <= n; j++) {
					dp[j] = Math.min(dp[j], dp[j - s] + 1);
				}
			}

			System.out.println(dp[n]);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
