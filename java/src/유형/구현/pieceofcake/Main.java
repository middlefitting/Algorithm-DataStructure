package 유형.구현.pieceofcake;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			System.out.println(Math.max(arr[0] - arr[1], arr[1]) * Math.max(arr[0] - arr[2], arr[2]) * 4);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
