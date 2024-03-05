package 유형.연결리스트.철도공사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static int[] pre = new int[1000001];
	private static int[] next = new int[1000001];
	private static StringBuffer sb = new StringBuffer();
	private static StringTokenizer st;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			// initialize
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			// int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			String[] input = br.readLine().split(" ");
			int[] nodes = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				nodes[i] = Integer.parseInt(input[i]);
			}
			int len = nodes.length;

			for (int i = 0; i < len; i++) {
				int nextIdx = i + 1 < len ? i + 1 : 0;
				int preIdx = i - 1 >= 0 ? i - 1 : len - 1;
				pre[nodes[i]] = nodes[preIdx];
				next[nodes[i]] = nodes[nextIdx];
			}

			// logic
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				String logic = st.nextToken();
				if (logic.equals("BN")) {
					int preNode = Integer.parseInt(st.nextToken());
					int newNode = Integer.parseInt(st.nextToken());
					int nextNode = next[preNode];
					sb.append(nextNode).append("\n");
					next[newNode] = nextNode;
					pre[newNode] = preNode;
					next[preNode] = newNode;
					pre[nextNode] = newNode;
				} else if (logic.equals("BP")) {
					int nextNode = Integer.parseInt(st.nextToken());
					int newNode = Integer.parseInt(st.nextToken());
					int preNode = pre[nextNode];
					sb.append(preNode).append("\n");
					next[newNode] = nextNode;
					pre[newNode] = preNode;
					next[preNode] = newNode;
					pre[nextNode] = newNode;
				} else if (logic.equals("CN")) {
					int preNode = Integer.parseInt(st.nextToken());
					int targetNode = next[preNode];
					int nextNode = next[targetNode];
					sb.append(targetNode).append("\n");
					next[preNode] = nextNode;
					pre[nextNode] = preNode;
				} else if (logic.equals("CP")) {
					int nextNode = Integer.parseInt(st.nextToken());
					int targetNode = pre[nextNode];
					int preNode = pre[targetNode];
					sb.append(targetNode).append("\n");
					next[preNode] = nextNode;
					pre[nextNode] = preNode;
				}
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

