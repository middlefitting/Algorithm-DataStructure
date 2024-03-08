package 유형.연결리스트.키로거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				keyLogger(br);
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void keyLogger(BufferedReader br) throws IOException {
		String input = br.readLine();
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '<') {
				if (!stack1.empty()) {
					stack2.push(stack1.pop());
				}
			} else if (c == '>') {
				if (!stack2.empty()) {
					stack1.push(stack2.pop());
				}
			} else if (c == '-') {
				if (!stack1.empty()) {
					stack1.pop();
				}
			} else {
				stack1.push(c);
			}
		}

		while (!stack1.empty()) {
			stack2.push(stack1.pop());
		}

		while (!stack2.empty()) {
			sb.append(stack2.pop());
		}

		sb.append("\n");
	}
}
