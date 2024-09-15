package 유형.우선순위큐.최솟값찾기;

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
			int l = Integer.parseInt(st.nextToken());
			PriorityQueue<Node> heap = new PriorityQueue<>();
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				heap.add(new Node(Integer.parseInt(st.nextToken()), i));
				int preIdx = i - l + 1;

				while (heap.peek().idx < preIdx) {
					heap.poll();
				}
				sb.append(heap.peek().num).append(" ");
			}
			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node implements Comparable<Node>{
		int num;
		int idx;

		public Node(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}

		@Override
		public int compareTo(Node o) {
			return this.num - o.num;
		}
	}
}
