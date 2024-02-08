package 단계별로풀어보기.스택큐덱.도키도키간식드리미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Stack<Integer> stack = new Stack<>();
			Stack<Integer> temp = new Stack<>();
			IntStream.range(0, n).forEach((i) -> temp.add(Integer.parseInt(st.nextToken())));
			while (!temp.empty()) {
				stack.add(temp.pop());
			}
			int idx = 1;
			while (!stack.empty() || !temp.empty()) {
				if (!stack.empty() && stack.peek() == idx) {
					stack.pop();
					idx++;
				} else if (!temp.empty() && temp.peek() == idx) {
					temp.pop();
					idx++;
				} else if (!stack.empty()) {
					temp.add(stack.pop());
				} else {
					break;
				}
			}
			if (stack.empty() && temp.empty()) {
				System.out.println("Nice");
			} else {
				System.out.println("Sad");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
