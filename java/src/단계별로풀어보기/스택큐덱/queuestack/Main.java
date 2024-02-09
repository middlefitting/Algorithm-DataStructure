package 단계별로풀어보기.스택큐덱.queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuffer result = new StringBuffer();

			int n = Integer.parseInt(br.readLine());

			List<String> s =
				Stream.of(br.readLine().split(" "))
					.collect(Collectors.toList());

			List<String> nums =
				Stream.of(br.readLine().split(" "))
					.collect(Collectors.toList());

			Deque<String> deque = IntStream.range(0, n)
				.filter((i) -> s.get(i).equals("0"))
				.mapToObj((i) -> nums.get(i))
				.collect(Collectors.toCollection(LinkedList::new));

			int m = Integer.parseInt(br.readLine());

			List<String> arr =
				Stream.of(br.readLine().split(" "))
					.collect(Collectors.toList());

			for (String x : arr) {
				deque.addFirst(x);
				result.append(deque.removeLast()).append(" ");
			}

			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
