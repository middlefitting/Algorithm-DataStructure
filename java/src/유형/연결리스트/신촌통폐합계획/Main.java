package 유형.연결리스트.신촌통폐합계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n + 1];
			int[] next = new int[n + 1];
			int[] tail = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				arr[i] = br.readLine();
				next[i] = i;
				tail[i] = i;
			}

			int node = 0;
			StringTokenizer st;
			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());

				next[tail[left]] = right;
				tail[left] = tail[right];

				if (i == n - 2) {
					node = left;
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append(arr[node]);
				node = next[node];
			}
			System.out.println(sb);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
