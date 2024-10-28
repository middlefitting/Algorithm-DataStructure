package 유형.해시.여우는어떻게울지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				String[] arr = br.readLine().split(" ");
				HashSet<String> set = new HashSet<>();
				while (true) {
					String s = br.readLine();
					if (s.equals("what does the fox say?")) {
						break;
					}
					set.add(s.split(" ")[2]);
				}

				StringBuilder sb = new StringBuilder();
				for (String cry : arr) {
					if (set.contains(cry)) {
						continue;
					}
					sb.append(cry).append(" ");
				}
				System.out.println(sb);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
