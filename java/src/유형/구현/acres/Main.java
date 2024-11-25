package 유형.구현.acres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			double a = Long.parseLong(st.nextToken());
			double b = Long.parseLong(st.nextToken());

			double ab = a * b;

			double result = ab / (4840 * 5);

			if (result % (4840 * 5) > 0) {
				result++;
			}

			System.out.println((long) Math.floor(result));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
