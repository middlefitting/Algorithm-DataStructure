package 알고리즘.easy.수도요금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			int d = Integer.parseInt(br.readLine());
			int p = Integer.parseInt(br.readLine());

			int x = a * p;
			int y = b + (Math.max(0, p - c) * d);
			System.out.println(Math.min(x, y));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
