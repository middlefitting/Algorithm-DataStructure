package 유형.투포인터.회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int[] arr = new int[n + k];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 0; i < k; i++) {
				arr[n + i] = arr[i];
			}

			Bill bill = new Bill(d);

			bill.add(c);
			for (int i = 0; i < k; i++) {
				bill.add(arr[i]);
			}

			int result = bill.result();
			int s = 0;
			int e = k - 1;

			while (e < n + k - 1) {
				bill.remove(arr[s]);
				s++;
				e++;
				bill.add(arr[e]);
				result = Math.max(result, bill.result());
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Bill {
		HashSet<Integer> set = new HashSet<>();
		int[] cnt;

		Bill(int d) {
			cnt = new int[d + 1];
		}

		public void add(int x) {
			set.add(x);
			cnt[x] += 1;
		}

		public void remove(int x) {
			cnt[x] -= 1;
			if (cnt[x] == 0) {
				set.remove(x);
			}
		}

		public int result() {
			return set.size();
		}
	}

}
