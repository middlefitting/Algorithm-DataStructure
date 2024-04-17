package 유형.트리.트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static HashMap<String, String[]> map = new HashMap<>();
	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		preOrder("A");
		System.out.println();
		inOrder("A");
		System.out.println();
		postOrder("A");
		System.out.println();
	}

	private static void preOrder(String root) {
		System.out.print(root);
		String[] child = map.get(root);
		if (!child[0].equals(".")) {
			preOrder(child[0]);
		}
		if (!child[1].equals(".")) {
			preOrder(child[1]);
		}
	}

	private static void inOrder(String root) {
		String[] child = map.get(root);
		if (!child[0].equals(".")) {
			inOrder(child[0]);
		}
		System.out.print(root);
		if (!child[1].equals(".")) {
			inOrder(child[1]);
		}
	}

	private static void postOrder(String root) {
		String[] child = map.get(root);
		if (!child[0].equals(".")) {
			postOrder(child[0]);
		}
		if (!child[1].equals(".")) {
			postOrder(child[1]);
		}
		System.out.print(root);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String root = st.nextToken();
				String leftChild = st.nextToken();
				String rightChild = st.nextToken();
				map.put(root, new String[] {leftChild, rightChild});
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
