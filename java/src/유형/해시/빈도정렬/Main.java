package 유형.해시.빈도정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.w3c.dom.Node;

public class Main {
	static class Node implements Comparable<Node>{
		int value;
		int cnt;
		int firstIdx;

		public Node(int value, int cnt, int firstIdx) {
			this.value = value;
			this.cnt = cnt;
			this.firstIdx = firstIdx;
		}

		@Override
		public int compareTo(Node o) {
			int result = Integer.compare(this.cnt * -1, o.cnt * -1);

			if (result == 0) {
				result = Integer.compare(this.firstIdx, o.firstIdx);
			}
			return result;
		}
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			Map<Integer, Node> map = new TreeMap<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(st.nextToken());
				int cnt = map.containsKey(temp) ? map.get(temp).cnt + 1 : 1;
				int idx = map.containsKey(temp) ? map.get(temp).firstIdx : i;
				map.put(temp, new Node(temp, cnt, idx));
			}

			Node[] arr = map.values().toArray(new Node[0]);
			Arrays.sort(arr);

			StringBuilder sb = new StringBuilder();
			for (Node node : arr) {
				for (int i = 0; i < node.cnt; i++) {
					sb.append(node.value).append(" ");
				}
			}

			System.out.println(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
