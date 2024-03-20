package 유형.위상정렬.작업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	private static Task[] tasks;

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		Queue<Task> queue = new LinkedList<>();
		Arrays.stream(tasks).filter(Task::possible).forEach(queue::add);
		while (!queue.isEmpty()) {
			Task task = queue.remove();
			for (Task child : task.child) {
				child.needs--;
				child.result = Math.max(task.result + child.times, child.result);
				if (child.possible()) {
					queue.add(child);
				}
			}
		}

		int answer = Arrays.stream(tasks).mapToInt((task) -> task.result).max().orElse(-1);
		System.out.println(answer);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			tasks = new Task[n + 1];
			StringTokenizer st;
			IntStream.rangeClosed(0, n).forEach((i) -> tasks[i] = new Task());
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				tasks[i].times = Integer.parseInt(st.nextToken());
				tasks[i].result = tasks[i].times;
				tasks[i].needs = Integer.parseInt(st.nextToken());
				for (int j = 0; j < tasks[i].needs; j++) {
					int parentIdx = Integer.parseInt(st.nextToken());
					tasks[parentIdx].child.add(tasks[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

class Task {
	int needs;
	int times;
	int result;
	ArrayList<Task> child = new ArrayList<>();

	public boolean possible() {
		return needs == 0;
	}
}
