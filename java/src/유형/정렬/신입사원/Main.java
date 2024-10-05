package 유형.정렬.신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st;
			while (t-- > 0) {
				int n = Integer.parseInt(br.readLine());
				Node[] nodes = new Node[n];
				for (int i = 0; i < n; i++) {
					st = new StringTokenizer(br.readLine());
					nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
				Arrays.sort(nodes);
				int cnt = 1;
				int maxInterview = nodes[0].interview;
				for (int i = 1; i < n; i++) {
					if (nodes[i].interview <= maxInterview) {
						maxInterview = nodes[i].interview;
						cnt++;
					}
				}
				System.out.println(cnt);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Node implements Comparable<Node> {
		int resume;
		int interview;

		public Node(int resume, int interview) {
			this.resume = resume;
			this.interview = interview;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.resume, o.resume);
		}
	}
}
