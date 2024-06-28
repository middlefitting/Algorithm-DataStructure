package 유형.문자열.닉네임에갓붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] arr = br.readLine().split(" ");
				arr[0] = "god";
				System.out.println(Arrays.stream(arr).map(String::valueOf).collect(Collectors.joining()));
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
