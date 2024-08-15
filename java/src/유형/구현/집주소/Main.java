package 유형.구현.집주소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				String num = br.readLine();
				if (num.equals("0")) {
					break;
				}
				int result = num.length() + 1;
				for (char c : num.toCharArray()) {
					if (c == '0') {
						result += 4;
					} else if (c == '1') {
						result += 2;
					} else {
						result += 3;
					}
				}
				System.out.println(result);
			}


		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
