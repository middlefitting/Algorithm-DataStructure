package 유형.우선순위큐.이중우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static PriorityQueue<Integer> min;
	static PriorityQueue<Integer> max;
	static int size;
	static HashMap<Integer, Integer> cnt;

	public static void main(String[] args) {
		StringTokenizer st;
		StringBuffer answer = new StringBuffer();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				min = new PriorityQueue<>();
				max = new PriorityQueue<>(Collections.reverseOrder());
				cnt = new HashMap<>();
				int k = Integer.parseInt(br.readLine());
				size = 0;
				for (int j = 0; j < k; j++) {
					st = new StringTokenizer(br.readLine());
					String operation = st.nextToken();
					int num = Integer.parseInt(st.nextToken());
					logic(operation, num);
				}
				if (size > 0) {
					int maxNum;
					int minNum;
					while (true) {
						maxNum = max.poll();
						if (cnt.getOrDefault(maxNum, 0) > 0) {
							break;
						}
					}
					while (true) {
						minNum = min.poll();
						if (cnt.getOrDefault(minNum, 0) > 0) {
							break;
						}
					}
					answer.append(maxNum).append(" ").append(minNum).append("\n");
				} else {
					answer.append("EMPTY\n");
				}
			}
			System.out.print(answer);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static void logic(String operation, int num) {
		if (operation.equals("I")) {
			max.add(num);
			min.add(num);
			cnt.put(num, cnt.getOrDefault(num, 0) + 1);
			size++;
		} else if (num == 1 && size > 0) {
			while (true) {
				int poll = max.poll();
				if (cnt.getOrDefault(poll, 0) > 0) {
					cnt.put(poll, cnt.getOrDefault(poll, 0) - 1);
					break;
				}
			}
			size--;
		} else if (num == -1 && size > 0) {
			while (true) {
				int poll = min.poll();
				if (cnt.getOrDefault(poll, 0) > 0) {
					cnt.put(poll, cnt.getOrDefault(poll, 0) - 1);
					break;
				}
			}
			size--;
		}
	}
}
