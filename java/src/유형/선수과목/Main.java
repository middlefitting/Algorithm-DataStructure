package 유형.선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static Subject[] subjects;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		Queue<Subject> queue = new LinkedList<>();
		Arrays.stream(subjects).filter(subject -> subject != null).filter(Subject::possible).forEach(queue::add);
		while (!queue.isEmpty()) {
			Subject parent = queue.remove();
			for (Subject child : parent.child) {
				child.need--;
				child.result = Math.max(child.result, parent.result + 1);
				if (child.possible()) {
					queue.add(child);
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		Arrays.stream(subjects)
			.filter(subject -> subject != null)
			.forEach(subject -> sb.append(subject.result).append(" "));
		System.out.println(sb);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			subjects = new Subject[n + 1];
			for (int i = 1; i <= n; i++) {
				subjects[i] = new Subject();
			}
			int m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				subjects[a].child.add(subjects[b]);
				subjects[b].need++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

class Subject {
	int need;
	int result = 1;
	ArrayList<Subject> child = new ArrayList<>();

	public boolean possible() {
		return need == 0;
	}
}
