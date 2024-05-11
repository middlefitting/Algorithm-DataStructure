package 알고리즘.easy.fbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			List<Integer> answer = new ArrayList<>();
			for (int i = 1; i <= 5; i++) {
				if (br.readLine().contains("FBI")) {
					answer.add(i);
				}
			}
			if (answer.isEmpty()) {
				System.out.println("HE GOT AWAY!");
			} else {
				StringBuffer sb = new StringBuffer();
				answer.forEach(a -> sb.append(a).append(" "));
				System.out.println(sb);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
