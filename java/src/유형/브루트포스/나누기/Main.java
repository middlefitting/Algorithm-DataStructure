package 유형.브루트포스.나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			char[] arr = br.readLine().toCharArray();
			String s = "";
			for (int i = 0; i < arr.length - 2; i++) {
				s += arr[i];
			}
			s += "00";
			int n = Integer.parseInt(s);
			int m = Integer.parseInt(br.readLine());

			for (int i = 0; i < 100; i++) {
				if ((n + i) % m == 0) {
					if (i < 10) {
						System.out.println("0" + i);
					} else {
						System.out.println(i);
					}
					break;
				}
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
