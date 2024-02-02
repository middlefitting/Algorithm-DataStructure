package 단계별로풀어보기.집합과맵.서로다른부분문자열의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			HashSet<String> set = new HashSet<>();
			StringBuilder sb = new StringBuilder();
			sb.append(br.readLine());
			for (int i = 0; i < sb.length(); i++) {
				for (int j = i; j < sb.length(); j++) {
					set.add(sb.substring(i, j + 1));
				}
			}
			System.out.println(set.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
