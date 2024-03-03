package 단계별로풀어보기.분할정복.이항계수3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	private static BigInteger n;
	private static BigInteger k;
	private static BigInteger p = BigInteger.valueOf(1000000007);

	public static void main(String[] args) {
		parse();
		BigInteger top = factorial(n);
		BigInteger bottom = factorial(n.subtract(k)).multiply(factorial(k)).mod(p);
		BigInteger result = top.multiply(bottom.modInverse(p)).mod(p);
		System.out.println(result);
	}

	private static BigInteger factorial(BigInteger n) {
		BigInteger result = BigInteger.ONE;
		for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			result = result.multiply(i).mod(p);
		}
		return result;
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = new BigInteger(st.nextToken());
			k = new BigInteger(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
