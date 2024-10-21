package 유형.해시.암기왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());

			while (t-- > 0) {
				int n = Integer.parseInt(br.readLine());
				HashSet<Integer> set = Arrays.stream(br.readLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toCollection(HashSet::new));

				StringBuilder sb = new StringBuilder();
				int m = Integer.parseInt(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int i = 0; i < m; i++) {
					sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
				}
				System.out.print(sb);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
