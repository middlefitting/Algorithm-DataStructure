package 단계별로풀어보기.스택큐덱.스택2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			Stack<Integer> stack = new Stack<>();
			StringBuffer sb = new StringBuffer();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				if (op == 1) {
					stack.add(Integer.parseInt(st.nextToken()));
				} else if (op == 2) {
					if (stack.size() != 0) {
						sb.append(stack.pop());
					} else {
						sb.append(-1);
					}
					sb.append("\n");
				} else if (op == 3) {
					sb.append(stack.size());
					sb.append("\n");
				} else if (op == 4) {
					if (stack.size() == 0) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					sb.append("\n");
				} else if (op == 5) {
					if (stack.size() == 0) {
						sb.append(-1);
					} else {
						Integer pop = stack.pop();
						sb.append(pop);
						stack.add(pop);
					}
					sb.append("\n");
				}
			}
			System.out.println(sb);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
