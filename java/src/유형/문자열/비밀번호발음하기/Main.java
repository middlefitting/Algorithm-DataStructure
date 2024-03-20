package 유형.문자열.비밀번호발음하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String temp;
			while (true) {
				temp = br.readLine();
				if (temp.equals("end")) {
					break;
				}
				logic(temp);
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static void logic(String temp) {
		boolean containsVowelFlag = temp.matches(".*[aeiou].*");
		boolean sameWord = true;
		for (int i = 1; i < temp.length(); i++) {
			if (temp.charAt(i) != 'e' && temp.charAt(i) != 'o' && temp.charAt(i) == temp.charAt(i - 1)) {
				sameWord = false;
				break;
			}
			if (i >= 2 && temp.substring(i, i + 1).matches(".*[aeiou].*")
				&& temp.substring(i - 1, i).matches(".*[aeiou].*")
				&& temp.substring(i - 2, i - 1).matches(".*[aeiou].*")) {
				sameWord = false;
				break;
			}

			if (i >= 2 && !temp.substring(i, i + 1).matches(".*[aeiou].*")
				&& !temp.substring(i - 1, i).matches(".*[aeiou].*")
				&& !temp.substring(i - 2, i - 1).matches(".*[aeiou].*")) {
				sameWord = false;
				break;
			}

		}


		if (containsVowelFlag && sameWord) {
			sb.append(String.format("<%s> is acceptable.\n", temp));
		} else {
			sb.append(String.format("<%s> is not acceptable.\n", temp));
		}
	}
}
