package 유형.에라토스테네스의채.소수와펠린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			boolean[] sosu = new boolean[10000002];
			Arrays.fill(sosu, true);
			sosu[0] = false;
			sosu[1] = false;
			for (int i = 2; i <= 10000001; i++) {
				if (!sosu[i]) {
					continue;
				}
				if (i >= n) {
					String s = String.valueOf(i);
					String c = new StringBuilder(s).reverse().toString();
					if (s.equals(c)) {
						System.out.println(i);
						break;
					}
				}
				int tmp = i * 2;
				while (tmp <= 10000001) {
					sosu[tmp] = false;
					tmp += i;
				}
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
