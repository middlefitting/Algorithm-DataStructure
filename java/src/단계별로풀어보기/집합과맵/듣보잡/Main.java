package 단계별로풀어보기.집합과맵.듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			HashMap<String, Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n + m; i++) {
				String name = br.readLine();
				map.put(name, map.getOrDefault(name, 0) + 1);
			}

			ArrayList<String> collect =
				map.keySet().stream()
					.filter((i) -> map.get(i) == 2)
					.sorted(Comparator.naturalOrder())
					.collect(Collectors.toCollection(ArrayList::new));

			String result =
				collect.stream()
					.collect(Collectors.joining("\n"));

			System.out.println(collect.size());
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
