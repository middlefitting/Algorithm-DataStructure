package 약수배수와소수2.최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long[] values =
				Stream.of(br.readLine().split(" "))
					.mapToLong(Long::parseLong)
					.sorted()
					.toArray();

			long contain = 1;
			long a = values[0];
			long b = values[1];
			long idx = 2;

			while (idx <= a) {
				if (a % idx == 0 && b % idx == 0) {
					contain *= idx;
					a /= idx;
					b /= idx;
					continue;
				}
				idx++;
			}

			System.out.println(contain * a * b);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
