package 유형.우선순위큐.파일합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int k = Integer.parseInt(br.readLine());
			int n;
			long result;
			StringBuffer sb = new StringBuffer();
			PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
			for (int i = 0; i < k; i++) {
				n = Integer.parseInt(br.readLine());
				result = 0;
				priorityQueue.clear();
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					priorityQueue.add(Long.parseLong(st.nextToken()));
				}
				for (int j = 0; j < n - 1; j++) {
					long a = priorityQueue.poll();
					long b = priorityQueue.poll();
					priorityQueue.add(a + b);
					result += a + b;
				}
				sb.append(result).append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
