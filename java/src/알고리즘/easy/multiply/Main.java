package 알고리즘.easy.multiply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			br.readLine();
			BigInteger a = BigInteger.valueOf(Integer.parseInt(br.readLine()));
			BigInteger b = BigInteger.valueOf(Integer.parseInt(br.readLine()));
			System.out.println(a.multiply(b));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
