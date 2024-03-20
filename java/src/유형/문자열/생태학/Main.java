package 유형.문자열.생태학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	private static Set<String> names = new HashSet<>();
	private static HashMap<String, Integer> counts = new HashMap<>();
	private static int totalCnt = 0;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		StringBuffer sb = new StringBuffer();
		List<String> collect = names.stream().sorted().collect(Collectors.toList());
		for (String name : collect) {
			sb.append(name);
			sb.append(" ");
			sb.append(String.format("%.4f", Math.round((double)counts.get(name) / (double)totalCnt * 100 * 10000) / 10000.0));
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String name;
			while (true) {
				name = br.readLine();
				if (name == null) {
					break;
				}
				names.add(name);
				counts.put(name, counts.getOrDefault(name, 0) + 1);
				totalCnt++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
