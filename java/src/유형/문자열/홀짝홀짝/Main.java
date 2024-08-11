package 유형.문자열.홀짝홀짝;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();

			int evenCnt = 0;
			int oddCnt = 0;

			for (char c : arr) {
				if ((c - '0') % 2 == 0) {
					evenCnt++;
				} else {
					oddCnt++;
				}
			}

			if (evenCnt == oddCnt) {
				System.out.println(-1);
			} else if (evenCnt > oddCnt) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
