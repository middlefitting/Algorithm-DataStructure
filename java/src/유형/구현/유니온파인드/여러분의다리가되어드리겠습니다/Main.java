package 유형.구현.유니온파인드.여러분의다리가되어드리겠습니다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] uf;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			uf = new int[n + 1];
			Arrays.fill(uf, -1);

			StringTokenizer st;
			for (int i = 0; i < n - 2; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			for (int i = 1; i <= n; i++) {
				if (find(i) == i) {
					System.out.print(i + " ");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int find(int a) {
		if (uf[a] < 0) {
			return a;
		}
		uf[a] = find(uf[a]);
		return find(uf[a]);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) {
			return false;
		}
		uf[a] = b;
		return true;
	}
}

