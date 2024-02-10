package 단계별로풀어보기.조합론.베라의패션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(n * (n - 1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
