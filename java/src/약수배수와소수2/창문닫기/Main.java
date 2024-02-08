package 약수배수와소수2.창문닫기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			System.out.println((int) Math.sqrt(n));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
