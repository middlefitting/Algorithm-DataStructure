package 유형.투포인터.겹치는건싫어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		logic(parse());
	}

	private static void logic(Data data) {
		int answer = 1;
		int s = 0;
		int e = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(data.arr[0], 1);

		while (e < data.n - 1) {
			e++;
			map.put(data.arr[e], map.getOrDefault(data.arr[e], 0) + 1);
			while (map.get(data.arr[e]) > data.k) {
				map.put(data.arr[s], map.getOrDefault(data.arr[s], 0) - 1);
				if (map.get(data.arr[s]) == 0) {
					map.remove(data.arr[s]);
				}
				s++;
			}
			answer = Math.max(e - s + 1, answer);
		}
		System.out.println(answer);
	}

	private static Data parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Data data = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			data.arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			return data;
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Data {
		int[] arr;
		int n;
		int k;

		public Data(int n, int k) {
			this.n = n;
			this.k = k;
			arr = new int[n];
		}
	}
}
