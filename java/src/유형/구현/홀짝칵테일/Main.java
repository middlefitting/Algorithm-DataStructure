package 유형.구현.홀짝칵테일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int[] arr = {a * b * c, a * b, a * c, b * c, a, b, c};

			Arrays.sort(arr);

			int idx = arr.length - 1;
			int answer = arr[idx];
			while (idx >= 0) {
				if (arr[idx] % 2 == 1) {
					answer = arr[idx];
					break;
				} else {
					answer = Math.max(answer, arr[idx]);
					idx--;
				}
			}

			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
