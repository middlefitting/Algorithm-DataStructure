package 단계별로풀어보기.심화2.영단어암기는어려워;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			LinkedHashMap<String, Integer> dict = new LinkedHashMap<>();
			for (int i = 0; i < n; i++) {
				String word = br.readLine();
				if (word.length() >= m) {
					int cnt = dict.getOrDefault(word, 0);
					dict.put(word, ++cnt);
				}
			}
			List<Map.Entry<String, Integer>> collect = dict.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
					.thenComparing(e -> e.getKey().length(), Comparator.reverseOrder())
					.thenComparing(Map.Entry.comparingByKey()))
				.collect(Collectors.toList());
			String result = collect.stream().map(Map.Entry::getKey).collect(Collectors.joining("\n"));
			bw.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
