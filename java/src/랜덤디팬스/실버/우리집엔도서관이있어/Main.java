package 랜덤디팬스.실버.우리집엔도서관이있어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;

public class Main {
	private static int[] arr;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		int num = arr.length - 1;
		while (num >= 1) {
			if (map.get(num + 1) < map.get(num)) {
				answer++;
				map.put(num, -1);
			}
			num--;
		}
		System.out.println(answer);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}




