package 단계별로풀어보기.스택큐덱.덱2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			Deque<String> deque = new LinkedList<>();
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String operation = st.nextToken();
				switch (operation) {
					case "1":
						deque.addFirst(st.nextToken());
						break;
					case "2":
						deque.addLast(st.nextToken());
						break;
					case "3":
						sb.append(deque.isEmpty() ? -1 : deque.removeFirst());
						sb.append("\n");
						break;
					case "4":
						sb.append(deque.isEmpty() ? -1 : deque.removeLast());
						sb.append("\n");
						break;
					case "5":
						sb.append(deque.size());
						sb.append("\n");
						break;
					case "6":
						sb.append(deque.isEmpty() ? 1 : 0);
						sb.append("\n");
						break;
					case "7":
						sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
						sb.append("\n");
						break;
					case "8":
						sb.append(deque.isEmpty() ? -1 : deque.peekLast());
						sb.append("\n");
						break;
				}
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

