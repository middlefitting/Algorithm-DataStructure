package 유형.우선순위큐.보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Jewel[] jewels = new Jewel[n];
			long[] bag = new long[m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				jewels[i] = new Jewel(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			}

			for (int i = 0; i < m; i++) {
				bag[i] = Long.parseLong(br.readLine());
			}

			Arrays.sort(jewels);
			Arrays.sort(bag);

			// 적은 무게로 담을 수 있는 보석을 모두 담는다는 것이 핵심 -> 반복을 제거하는 방법
			PriorityQueue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());
			long result = 0;
			int idx = 0;

			for (int i = 0; i < m; i++) {
				while (idx < n && jewels[idx].weight <= bag[i]) {
					heap.add(jewels[idx].value);
					idx++;
				}
				if (!heap.isEmpty()) {
					result += heap.remove();
				}
			}

			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException();
		}

	}

	static class Jewel implements Comparable<Jewel> {
		long weight;
		long value;

		public Jewel(long weight, long value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Jewel o) {
			return Long.compare(this.weight, o.weight);
		}
	}
}
