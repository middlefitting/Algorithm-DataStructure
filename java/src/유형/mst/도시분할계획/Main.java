package 유형.mst.도시분할계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] uf;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			uf = new int[n + 1];
			Arrays.fill(uf, -1);

			int result = 0;
			int v = 0;

			Node[] arr = new Node[m];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(arr);

			for (int i = 0; i < m; i++) {
				Node node = arr[i];
				if (v == n - 2) {
					break;
				}
				if (union(node.a, node.b)) {
					result += node.c;
					v++;
				}
			}
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int find(int x) {
		if (uf[x] < 0) {
			return x;
		}
		uf[x] = find(uf[x]);
		return find(uf[x]);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return false;
		}
		uf[a] = b;
		return true;
	}

	static class Node implements Comparable<Node> {
		int a;
		int b;
		int c;

		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(c, o.c);
		}
	}
}
