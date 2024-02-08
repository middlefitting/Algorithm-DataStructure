package 단계별로풀어보기.시간복잡도.알고리즘수업알고리즘의수행시간4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long n = Long.parseLong(br.readLine());
			long result = 0;
			for (long i = 1; i < n; i++) {
				result += i;
			}
			System.out.println(result);
			System.out.println(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
