package 유형.구현.odd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long n = Integer.parseInt(br.readLine());
			long result = Arrays.stream(br.readLine().split(" "))
				.mapToLong(Long::parseLong)
				.filter((x) -> x % 2 != 1)
				.count();
			if (n - result < result) {
				System.out.println("Happy");
			} else {
				System.out.println("Sad");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
