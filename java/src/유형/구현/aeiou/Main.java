package 유형.구현.aeiou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toLowerCase().toCharArray();
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] == 'a' || arr[i] == 'e' ||arr[i] == 'i' ||arr[i] == 'o' ||arr[i] == 'u') {
					cnt++;
				}
			}
			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
