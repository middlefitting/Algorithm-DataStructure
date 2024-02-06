package 약수배수와소수2.분수합;

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

			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int head = a * d + c * b;
			int bottom = b * d;

			int idx = 2;
			while (idx <= head && idx <= bottom) {
				if (head % idx == 0 && bottom % idx == 0) {
					head /= idx;
					bottom /= idx;
					continue;
				}
				idx++;
			}
			System.out.println(head + " " + bottom);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
