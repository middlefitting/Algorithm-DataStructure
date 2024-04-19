package 유형.이진트리.무한수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static HashMap<Long, Long> map = new HashMap<>();

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			long q = Long.parseLong(st.nextToken());

			System.out.println(dfs(n));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static long dfs(long n) {
		long temp = map.getOrDefault(n, -1L);

		return 0L;
	}
}
