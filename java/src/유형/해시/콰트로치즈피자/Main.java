package 유형.해시.콰트로치즈피자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			String[] list = br.readLine().split(" ");
			HashSet<String> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				set.add(list[i]);
			}

			int cnt = 0;
			for (String topping : set) {
				if (topping.length() >= 6) {
					if (topping.endsWith("Cheese")) {
						cnt++;
					}
				}
			}

			if (cnt >= 4) {
				System.out.println("yummy");
			} else {
				System.out.println("sad");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
