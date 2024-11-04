package 유형.해시.동일한단어그룹화하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			HashSet<String> set = new HashSet<>();

			for (int i = 0; i < n; i++) {
				char[] arr = br.readLine().toCharArray();
				Arrays.sort(arr);
				set.add(new String(arr));
			}

			System.out.println(set.size());
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
