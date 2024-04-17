package 유형.누적합.구간합구하기4;

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
			int m = Integer.parseInt(st.nextToken());
			long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long[] sum = new long[n + 1];
			for (int i = 1; i <= n; i++) {
				sum[i] = sum[i - 1] + arr[i - 1];
			}

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				sb.append(sum[e] - sum[s - 1]).append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
