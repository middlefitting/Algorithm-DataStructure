package 단계별로풀어보기.집합과맵.숫자카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static LinkedHashSet<Integer> parseSet() {
		try {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr =
				Stream.of(br.readLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toCollection(ArrayList::new));
			return
				arr.stream()
					.limit(n)
					.collect(Collectors.toCollection(LinkedHashSet::new));

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) throws IOException {
		LinkedHashSet<Integer> arr = parseSet();
		LinkedHashSet<Integer> compare = parseSet();
		StringBuffer sb = new StringBuffer();
		compare.stream()
			.forEach((i) -> {
				if (arr.contains(i)) {
					sb.append("1");
					sb.append(" ");
				} else {
					sb.append("0");
					sb.append(" ");
				}
			});
		System.out.println(sb);
		br.close();
	}
}
