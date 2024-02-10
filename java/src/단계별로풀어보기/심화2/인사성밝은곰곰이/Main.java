package 단계별로풀어보기.심화2.인사성밝은곰곰이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	private static final String newUser = "ENTER";

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			Set<String> writers = new HashSet<>((int) (100000 / 0.75 + 1), 0.75f);
			for (int i = 0; i < n; i++) {
				String chat = br.readLine();
				if (chat.equals(newUser)) {
					answer += writers.size();
					writers.clear();
				} else {
					writers.add(chat);
				}
			}
			answer += writers.size();
			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
