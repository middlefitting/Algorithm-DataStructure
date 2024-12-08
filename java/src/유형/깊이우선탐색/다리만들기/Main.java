package 유형.깊이우선탐색.다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] mvs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	static int[][] uf;

	static int n;
	static int m;

	static int landCnt = 0;

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][m];
			uf = new int[n][m];

			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				Arrays.fill(uf[i], -1);
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int[] mv : mvs) {
						int tx = i + mv[0];
						int ty = j + mv[1];

						if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
							continue;
						}

						if (arr[tx][ty] != 1 || arr[i][j] != 1) {
							continue;
						}

						merge(tx, ty, i, j);
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] != 0 && uf[i][j] == -1) {
						landCnt++;
					}
				}
			}

			dfs(0, arr, 0, 0);

			if (answer == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(answer);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static void dfs(int depth, int[][] arr, int cnt, int findCnt) {
		int x = depth / m;
		int y = depth % m;

		if (findCnt == landCnt - 1) {

			// if (answer > cnt) {
			// 	System.out.println("\\\\\\\\\\\\\\\\\\\\");
			// 	System.out.println(cnt);
			// 	for (int i = 0; i < n; i++) {
			// 		System.out.println(Arrays.stream(arr[i]).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
			// 	}
			// 	System.out.println("\\\\\\\\\\\\\\\\\\\\");
			// }

			answer = Math.min(answer, cnt);
			return;
		}

		if (depth == n * m) {
			return;
		}

		if (arr[x][y] == 1) {
			dfs(depth + 1, arr, cnt, findCnt);
			return;
		}

		for (int t = 0; t < 2; t++) {
			int[] mv1 = mvs[t * 2];
			int[] mv2 = mvs[t * 2 + 1];

			int tempCnt = 1;
			boolean flag = true;

			int tx = mv1[0] + x;
			int ty = mv1[1] + y;

			while (true) {
				if (tx < 0 || ty < 0 || tx >= n || ty >= m) {
					flag = false;
					break;
				}

				if (arr[tx][ty] == 1) {
					break;
				} else {
					tempCnt++;
					tx += mv1[0];
					ty += mv1[1];
				}
			}

			if (!flag) {
				continue;
			}

			int tx2 = mv2[0] + x;
			int ty2 = mv2[1] + y;

			while (true) {
				if (tx2 < 0 || ty2 < 0 || tx2 >= n || ty2 >= m) {
					flag = false;
					break;
				}

				if (arr[tx2][ty2] == 1) {
					break;
				} else {
					tempCnt++;
					tx2 += mv2[0];
					ty2 += mv2[1];
				}
			}

			if (tempCnt < 2) {
				continue;
			}

			if (!flag) {
				continue;
			}

			if (find(tx, ty) == find(tx2, ty2)) {
				flag = false;
			}

			if (!flag) {
				continue;
			}
			int temptemp = tempCnt;

			int[][] tempArr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					tempArr[i][j] = arr[i][j];
				}
			}

			tempArr[x][y] = 2;
			tx = mv1[0] + x;
			ty = mv1[1] + y;
			tempCnt = 0;

			while (true) {
				if (tx < 0 || ty < 0 || tx >= n || ty >= m) {
					break;
				}

				if (arr[tx][ty] == 1) {
					break;
				} else {
					if (tempArr[tx][ty] != 2) {
						tempCnt++;
					}
					tempArr[tx][ty] = 2;
					tx += mv1[0];
					ty += mv1[1];
				}
			}

			tx2 = mv2[0] + x;
			ty2 = mv2[1] + y;

			while (true) {
				if (tx2 < 0 || ty2 < 0 || tx2 >= n || ty2 >= m) {
					break;
				}

				if (arr[tx2][ty2] == 1) {
					break;
				} else {
					if (tempArr[tx][ty] != 2) {
						tempCnt++;
					}
					tempArr[tx2][ty2] = 2;
					tx2 += mv2[0];
					ty2 += mv2[1];
				}
			}

			int a = find(tx, ty);
			int b = find(tx2, ty2);
			merge(tx, ty, tx2, ty2);

			dfs(depth, tempArr, cnt + temptemp, findCnt + 1);

			uf[a / 11][a % 11] = -1;
		}

		dfs(depth + 1, arr, cnt, findCnt);
	}

	private static void merge(int tx, int ty, int i, int j) {
		int a = find(tx, ty);
		int b = find(i, j);
		if (a != b) {
			uf[a / 11][a % 11] = b;
		}
	}

	private static int find(int x, int y) {
		if (uf[x][y] < 0) {
			return x * 11 + y;
		}

		int temp = uf[x][y];

		// uf[x][y] = find(temp / 11, temp % 11);
		return find(uf[x][y] / 11, uf[x][y] % 11);
	}
}
