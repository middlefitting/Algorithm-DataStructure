package 랜덤디팬스.실버.착신전환소동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int answer = 0;
			// 자신이 아닌 다른곳으로 보내면 무조건 사이클이 된다.
			for (int i = 0; i < n; i++) {
				if (arr[i] == (i + 1)) {
					arr[i] = i + 2;
					if (i == n - 1) {
						arr[i] = i;
					}
					answer++;
				}
			}
			System.out.println(answer);
			System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
