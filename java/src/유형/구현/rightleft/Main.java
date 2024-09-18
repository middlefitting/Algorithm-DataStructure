package 유형.구현.rightleft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
			if (sum > 0) {
				System.out.println("Right");
			} else if (sum == 0) {
				System.out.println("Stay");
			} else {
				System.out.println("Left");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
