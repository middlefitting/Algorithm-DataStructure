package 유형.구현.lucky7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
			boolean divFlag = n % 7 == 0 ? true : false;
			boolean containFlag = Arrays.stream(arr).anyMatch((i) -> i == 7);
			if (!divFlag && !containFlag) {
				System.out.println(0);
			} else if (!containFlag && divFlag) {
				System.out.println(1);
			} else if (containFlag && !divFlag) {
				System.out.println(2);
			} else {
				System.out.println(3);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}

