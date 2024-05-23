package 유형.해시.수찾기;

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
			int n = Integer.parseInt(br.readLine());
			HashSet<String> set = Arrays.stream(br.readLine().split(" "))
				.collect(Collectors.toCollection(() -> new HashSet<>(Math.max((int)(n / 0.75f) + 1, 16))));
			int m = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuffer sb = new StringBuffer();
			String contain = "1\n";
			String notContain = "0\n";
			for (int i = 0; i < m; i++) {
				if (set.contains(st.nextToken())) {
					sb.append(contain);
				} else {
					sb.append(notContain);
				}
			}
			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
