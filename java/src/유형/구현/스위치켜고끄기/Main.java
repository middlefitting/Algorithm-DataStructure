package 유형.구현.스위치켜고끄기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int gender = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());

				if (gender == 1) {
					int idx = num;
					while (idx <= n) {
						change(arr, idx);
						idx += num;
					}
				} else {
					change(arr, num);
					int move = 1;
					while (num + move - 1 < n && num - move - 1 >= 0) {
						if (arr[num + move - 1] == arr[num - move - 1]) {
							change(arr, num + move);
							change(arr, num - move);
						} else {
							break;
						}
						move++;
					}
				}
			}

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i++) {
				sb.append(arr[i]).append(" ");
				if (i % 20 == 19) {
					sb.append("\n");
				}
			}

			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static void change(int[] arr, int idx) {
		if (arr[idx - 1] == 1) {
			arr[idx - 1] = 0;
		} else {
			arr[idx - 1] = 1;
		}
	}
}
