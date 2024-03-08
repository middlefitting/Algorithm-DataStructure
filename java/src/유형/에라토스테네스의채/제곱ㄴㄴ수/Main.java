package 유형.에라토스테네스의채.제곱ㄴㄴ수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	private static long low;
	private static long big;

	private static HashSet<Long> invalid = new HashSet<>();

	public static void main(String[] args) {
		parse();
		logic();
		System.out.println(big - low + 1 - invalid.size());
	}

	private static void logic() {
		for (long i = 2; i <= Math.sqrt(big); i++) {
			long temp = (long)Math.pow(i, 2);
			long idx = low / temp;
			if (low % temp > 0) {
				idx++;
			}
			while (idx * temp <= big) {
				invalid.add(idx * temp);
				idx++;
			}
		}
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			low = Long.parseLong(st.nextToken());
			big = Long.parseLong(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

