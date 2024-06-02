package 유형.문자열.정수의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] arr = Arrays.stream(br.readLine().split(",")).toArray(String[]::new);
			System.out.println(arr.length);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
