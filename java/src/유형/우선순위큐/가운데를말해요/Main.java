package 유형.우선순위큐.가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> bigQueue = new PriorityQueue<>();
			PriorityQueue<Integer> smallQueue = new PriorityQueue<>(Comparator.reverseOrder());

			StringBuffer sb = new StringBuffer();
			int mid = -1;
			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(br.readLine());
				if (i == 1) {
					sb.append(num).append("\n");
					bigQueue.add(num);
				} else if (i == 2) {
					if (bigQueue.peek() < num) {
						smallQueue.add(bigQueue.remove());
						bigQueue.add(num);
					} else {
						smallQueue.add(num);
					}
					sb.append(smallQueue.peek()).append("\n");
				} else {
					if (i % 2 == 1) {
						if (smallQueue.peek() <= num && bigQueue.peek() >= num) {
							mid = num;
						} else if (smallQueue.peek() > num) {
							mid = smallQueue.remove();
							smallQueue.add(num);
						} else {
							mid = bigQueue.remove();
							bigQueue.add(num);
						}
						sb.append(mid).append("\n");
					} else {
						if (mid > num) {
							bigQueue.add(mid);
							smallQueue.add(num);
						} else {
							smallQueue.add(mid);
							bigQueue.add(num);
						}
						sb.append(smallQueue.peek()).append("\n");
					}
				}
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}

