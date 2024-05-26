package 유형.문자열.문서검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String target = br.readLine();
			int len = target.length();
			String find = br.readLine();
			int findLen = find.length();

			int result = 0;
			int idx = 0;
			while (idx < len) {
				idx = target.indexOf(find, idx);
				if (idx == -1) {
					break;
				}
				idx += findLen;
				result++;
			}
			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
