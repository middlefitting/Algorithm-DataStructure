package 유형.큐.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int k;
	static int l;
	static boolean[][] map;
	static boolean[][] v;

	static Queue<Move> mv = new LinkedList<>();

	public static void main(String[] args) {
		parse();
		logic();
	}

	private static void logic() {
		Deque<Node> snake = new LinkedList<>();
		snake.add(new Node(0, 0));
		v[0][0] = true;

		int cnt = 0;
		Move.Direction direction = Move.Direction.RIGHT;
		boolean flag = true;
		while (flag) {
			Move next;
			if (!mv.isEmpty()) {
				next = mv.poll();
			} else {
				next = new Move(Integer.MAX_VALUE, null);
			}

			while (cnt < next.time) {
				Node head = snake.peekFirst();
				Node newHead = new Node(head.x + direction.direction[0], head.y + direction.direction[1]);
				if (newHead.x < 0 || newHead.y < 0 || newHead.x >= n || newHead.y >= n) {
					flag = false;
					break;
				}
				if (v[newHead.x][newHead.y]) {
					flag = false;
					break;
				}
				if (map[newHead.x][newHead.y]) {
					map[newHead.x][newHead.y] = false;
				} else {
					Node tail = snake.pollLast();
					v[tail.x][tail.y] = false;
				}

				v[newHead.x][newHead.y] = true;
				snake.addFirst(newHead);
				cnt++;
			}
			if (flag) {
				direction = next.turn(direction);
			}
		}
		System.out.println(cnt + 1);
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			map = new boolean[n][n];
			v = new boolean[n][n];
			k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				map[x][y] = true;
			}

			l = Integer.parseInt(br.readLine());
			for (int i = 0; i < l; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				mv.add(new Move(Integer.parseInt(st.nextToken()), st.nextToken()));
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Move {
		int time;
		String dir;

		Move(int time, String dir) {
			this.time = time;
			this.dir = dir;
		}

		public Direction turn(Direction direction) {
			int[] result;
			if (dir.equals("L")) {
				result = direction.left;
			} else {
				result = direction.right;
			}
			if (result[0] == 0 && result[1] == 1) {
				return Direction.RIGHT;
			} else if (result[0] == 0 && result[1] == -1) {
				return Direction.LEFT;
			} else if (result[0] == -1 && result[1] == 0) {
				return Direction.UP;
			} else {
				return Direction.DOWN;
			}
		}

		enum Direction {
			RIGHT(new int[] {0, 1}, new int[] {1, 0}, new int[] {-1, 0}),
			LEFT(new int[] {0, -1}, new int[] {-1, 0}, new int[] {1, 0}),
			UP(new int[] {-1, 0}, new int[] {0, 1}, new int[] {0, -1}),
			DOWN(new int[] {1, 0}, new int[] {0, -1}, new int[] {0, 1});

			private final int[] direction;
			private final int[] right;
			private final int[] left;

			Direction(int[] direction, int[] right, int[] left) {
				this.direction = direction;
				this.right = right;
				this.left = left;
			}
		}
	}

}
