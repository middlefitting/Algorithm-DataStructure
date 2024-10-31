package 유형.구현.서버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			int num = Integer.parseInt(st.nextToken());

			Queue<Integer> queue = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toCollection(LinkedList::new));

			int cnt = 0;

			while (true) {

				if (queue.peek() == null) {

					break;
				}

				if (num - queue.peek() >= 0) {

					int temp = queue.poll();
					num -= temp;
					cnt++;
				} else {

					break;
				}
			}

			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
