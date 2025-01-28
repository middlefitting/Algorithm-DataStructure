package 유형.구현.거북이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			Arrays.sort(arr);

			System.out.println(arr[0] * arr[2]);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
