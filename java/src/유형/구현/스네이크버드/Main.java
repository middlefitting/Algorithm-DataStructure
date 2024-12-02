package 유형.구현.스네이크버드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int snakeBird = Integer.parseInt(st.nextToken());

			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(arr);

			for (int i = 0; i < n; i++) {

				if (snakeBird >= arr[i]) {
					snakeBird++;
				}
			}

			System.out.println(snakeBird);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
