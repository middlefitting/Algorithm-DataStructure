package 시간복잡도.알고리즘수업알고리즘의수행시간6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long n = Long.parseLong(br.readLine());
			long result = n * (n - 1) * (n - 2) / 6;
			System.out.println(result);
			System.out.println(3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
