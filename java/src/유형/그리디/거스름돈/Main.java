package 유형.그리디.거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = 1000 - Integer.parseInt(br.readLine());
			int[] coins = {500, 100, 50, 10, 5, 1};
			int cnt = 0;
			for (int coin : coins) {
				cnt += n / coin;
				n %= coin;
			}
			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
