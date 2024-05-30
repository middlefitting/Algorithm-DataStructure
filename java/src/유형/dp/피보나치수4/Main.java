package 유형.dp.피보나치수4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			BigInteger a1 = new BigInteger("0");
			BigInteger a2 = new BigInteger("1");

			for (int i = 2; i <= n; i++) {
				BigInteger temp = a1.add(a2);
				a1 = a2;
				a2 = temp;
			}
			if (n == 0) {
				System.out.println(0);
			} else {
				System.out.println(a2);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
