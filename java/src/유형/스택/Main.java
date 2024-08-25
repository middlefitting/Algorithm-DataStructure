package 유형.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Node[] arr;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		Stack<Node> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int result = 0;
			while (!stack.isEmpty()) {
				Node node = stack.pop();
				if (node.num >= arr[i].num) {
					result = node.idx;
					stack.push(node);
					break;
				}
			}
			stack.push(arr[i]);
			sb.append(result + " ");
		}

		System.out.println(sb);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			arr = new Node[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = new Node(Integer.parseInt(st.nextToken()), i + 1);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node {
		int num;
		int idx;

		public Node(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
}
