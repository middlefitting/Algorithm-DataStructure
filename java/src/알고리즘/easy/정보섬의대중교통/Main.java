package 알고리즘.easy.정보섬의대중교통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (n <= b) {
				if (a < b) {
					System.out.println("Bus");
				} else if (a == b) {
					System.out.println("Anything");
				} else {
					System.out.println("Subway");
				}
			} else {
				System.out.println("Bus");
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
