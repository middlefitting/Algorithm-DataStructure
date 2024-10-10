package 유형.우선순위큐.카드합체놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			PriorityQueue<Long> heap = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				heap.add(Long.parseLong(st.nextToken()));
			}

			while (m-- > 0) {
				long sum = heap.remove() + heap.remove();
				heap.add(sum);
				heap.add(sum);
			}

			long result = 0;
			while (n-- > 0) {
				result += heap.remove();
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
