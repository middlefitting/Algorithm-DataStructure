package 유형.투포인터.수들의합5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long n = 10000000;
			long m = Long.parseLong(br.readLine());
			long temp = 1;
			long cnt = 0;

			long s = 1;
			long e = 1;

			while (e <= n) {
				if (temp == m) {
					cnt++;
				}

				if (temp < m) {
					e++;
					temp += e;
				} else {
					temp -= s;
					s++;
					if (s > e) {
						e = s;
						temp += e;
					}
				}
			}

			System.out.println(cnt);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
