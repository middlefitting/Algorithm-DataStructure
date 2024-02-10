package 단계별로풀어보기.심화2.붙임성좋은촘촘이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			HashSet<String> rainbowDancers = new HashSet<>();
			rainbowDancers.add("ChongChong");
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String dancerA = st.nextToken();
				String dancerB = st.nextToken();
				if (rainbowDancers.contains(dancerA) || rainbowDancers.contains(dancerB)) {
					rainbowDancers.add(dancerA);
					rainbowDancers.add(dancerB);
				}
			}
			System.out.println(rainbowDancers.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
