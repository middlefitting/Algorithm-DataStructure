package 유형.구현.카드셋트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();

			int len = s.length();

			int pLost = 13;
			int kLost = 13;
			int hLost = 13;
			int tLost = 13;

			HashSet<String> set = new HashSet<>();

			for (int i = 0; i < len; i += 3) {
				char type = s.charAt(i);

				String temp = s.substring(i, i + 3);

				if (set.contains(temp)) {
					System.out.println("GRESKA");
					System.exit(0);
				} else {
					set.add(temp);
				}

				if (type == 'P') {
					pLost--;
				} else if (type == 'K') {
					kLost--;
				} else if (type == 'H') {
					hLost--;
				} else if (type == 'T') {
					tLost--;
				}
			}

			System.out.println(pLost + " " + kLost + " " + hLost + " " + tLost);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
