package 알고리즘.easy.감마선을맞은컴퓨터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			for (int i = 0; i < 15; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 15; j++) {
					set.add(st.nextToken());
				}
			}
			if (set.contains("w")) {
				System.out.println("chunbae");
			} else if (set.contains("b")) {
				System.out.println("nabi");
			} else {
				System.out.println("yeongcheol");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
