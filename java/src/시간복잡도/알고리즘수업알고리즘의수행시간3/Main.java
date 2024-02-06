package 시간복잡도.알고리즘수업알고리즘의수행시간3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			System.out.println((long)Math.pow(n, 2));
			System.out.println(2);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
