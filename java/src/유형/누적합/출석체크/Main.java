package 유형.누적합.출석체크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) + 2;
			int k = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n + 1];
			int[] sums = new int[n + 1];

			HashSet<Integer> sleep = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toCollection(HashSet::new));

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < q; i++) {
				int student = Integer.parseInt(st.nextToken());
				if (sleep.contains(student)) {
					continue;
				}
				int idx = student;
				while (idx <= n) {
					if (!sleep.contains(idx)) {
						arr[idx] = 1;
					}
					idx += student;
				}
			}

			for (int i = 1; i <= n; i++) {
				sums[i] = sums[i - 1] + arr[i];
			}

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				sb.append(e - s + 1 - sums[e] + sums[s - 1]).append("\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
