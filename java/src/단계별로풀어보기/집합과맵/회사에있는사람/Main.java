package 단계별로풀어보기.집합과맵.회사에있는사람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String enter = "enter";
			int n = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken(" ");
				String action = st.nextToken();
				if (action.equals(enter)) {
					set.add(name);
				} else {
					set.remove(name);
				}
			}

			String result = set.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.joining("\n"));

			System.out.println(result);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
