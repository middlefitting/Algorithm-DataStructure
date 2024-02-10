package 단계별로풀어보기.재귀.칸토어집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	private static ArrayList<String> arr = new ArrayList<>();

	private static void dfs(int s, int e) {
		if (e - s < 3) {
			return;
		}
		int m_s = s + (e - s) / 3;
		int m_e = s + (e - s) / 3 * 2;
		IntStream.range(m_s, m_e).forEach((i) -> arr.set(i, " "));
		dfs(s, m_s);
		dfs(m_e, e);
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuffer sb = new StringBuffer();
			while (true) {
				String line = br.readLine();
				if (line == null || line.isEmpty()) {
					break;
				}
				Integer num = Integer.parseInt(line);
				arr.clear();
				IntStream.range(0, (int) Math.pow(3, num)).forEach((i) -> arr.add("-"));
				dfs(0, (int)Math.pow(3, num));
				String collect = arr.stream().collect(Collectors.joining(""));
				sb.append(collect).append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
