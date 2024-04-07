package 유형.우선순위큐.최소회의실개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	private static int n;
	private static List<int[]> collect;
	private static PriorityQueue<Integer> rooms = new PriorityQueue<>();

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		for (int[] meeting : collect) {
			Integer peek = rooms.peek();
			if (peek != null && peek <= meeting[0]) {
				rooms.poll();
			}
			rooms.add(meeting[1]);
		}
		System.out.println(rooms.size());
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			int[][] nums = new int[n][2];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				nums[i][0] = Integer.parseInt(st.nextToken());
				nums[i][1] = Integer.parseInt(st.nextToken());
			}
			collect = Arrays.stream(nums)
				.sorted(Comparator.comparing(temp -> temp[0]))
				.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
