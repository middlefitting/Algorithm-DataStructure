package 시간복잡도.알고리즘수업점근적표기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(br.readLine());
			int d = Integer.parseInt(br.readLine());

			if (a * d + b > c * d) {
				System.out.println(0);
			} else {
				if (a > c) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
