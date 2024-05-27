package 유형.기하학.어린왕자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < t; i++) {
				int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int m = Integer.parseInt(br.readLine());
				Star[] stars = new Star[m];
				for (int j = 0; j < m; j++) {
					int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
					stars[j] = new Star(info[0], info[1], info[2]);
				}
				sb.append(logic(nodes, stars)).append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static int logic(int[] nodes, Star[] stars) {
		int result = 0;
		Node start = new Node(nodes[0], nodes[1]);
		Node end = new Node(nodes[2], nodes[3]);
		for (int i = 0; i < stars.length; i++) {
			if ((start.isIn(stars[i]) ^ end.isIn(stars[i]))) {
				result++;
			}
		}
		return result;
	}

	static class Star {
		int x;
		int y;
		int r;

		Star(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		boolean isIn(Star star) {
			return Math.pow(x - star.x, 2) + Math.pow(y - star.y, 2) < Math.pow(star.r, 2);
		}
	}
}

