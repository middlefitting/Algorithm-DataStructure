package 랜덤디팬스.실버.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long[] sort = Arrays.stream(arr).toArray();
			Arrays.sort(arr);
			int flag = 1;
			int dir = -1;
			for (int i = 0; i < n - 1; i++) {
				if (arr[i] != sort[i]) {
					if (flag == 1) {
						flag = 0;
						if (i == (n - 2)) {
							flag = 2;
						}
					} else if(flag == 0) {
						if (dir == -1) {
							if (arr[i] == sort[i + 1]) {
								dir = 1;
							} else if (sort[i] == arr[i + 1]) {
								dir = 2;
							} else {
								flag = -1;
								break;
							}
							if (i == (n - 1)) {
								flag = 2;
							}
						} else {
							if (dir == 1 && arr[i] != sort[i + 1]) {
								flag = -1;
								break;
							} else if (dir == 2 && sort[i] != arr[i + 1]) {
								flag = -1;
								break;
							}
						}
					}
				}
			}

			if (flag == 1) {
				System.out.println(n);
			} else if (flag == 2) {
				System.out.println(2);
			} else if (flag == 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// 1 3 5 2
// 1 2 3 5

// 1 5 2 2
// 1 2 2 5

// 1 2 3 2
// 1 2 2 3
