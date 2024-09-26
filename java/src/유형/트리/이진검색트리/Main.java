package 유형.트리.이진검색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			BinarySearchTree root = null;
			while (true) {
				String s = br.readLine();
				if (s == null || s.isEmpty()) {
					break;
				}
				int n = Integer.parseInt(s);
				if (root == null) {
					root = new BinarySearchTree(n);
				} else {
					root.add(n);
				}
			}

			root.PrintPostOrder();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class BinarySearchTree {
		int value;
		BinarySearchTree left;
		BinarySearchTree right;

		public BinarySearchTree(int value) {
			this.value = value;
		}

		public void PrintPostOrder() {
			StringBuilder sb = new StringBuilder();
			postOrder(this, sb);
			System.out.print(sb);
		}

		private void postOrder(BinarySearchTree tree, StringBuilder sb) {
			if (tree.left != null) {
				postOrder(tree.left, sb);
			}
			if (tree.right != null) {
				postOrder(tree.right, sb);
			}
			sb.append(tree.value).append("\n");
		}

		public void add(int n) {
			if (n <= value) {
				if (left == null) {
					left = new BinarySearchTree(n);
				} else {
					left.add(n);
				}
			} else {
				if (right == null) {
					right = new BinarySearchTree(n);
				} else {
					right.add(n);
				}
			}
		}
	}

}
