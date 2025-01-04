package 유형.구현.노래악보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			int[] arr = new int[100 * 100];

			int temp = 0;
			for (int i = 1; i <= n; i++) {

				int time = Integer.parseInt(br.readLine());
				for (int j = temp; j < temp + time; j++) {
					arr[j] = i;
				}
				temp += time;
			}

			for (int i = 0; i < t; i++) {
				System.out.println(arr[Integer.parseInt(br.readLine())]);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
