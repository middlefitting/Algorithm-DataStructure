package 약수배수와소수2.가로수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			ArrayList<Integer> arr = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				arr.add(Integer.parseInt(br.readLine()));
			}
			int depth = arr.get(1) - arr.get(0);
			for (int i = 1; i < arr.size() - 1; i++) {
				int temp = 1;
				int a = depth;
				int b = arr.get(i + 1) - arr.get(i);
				int idx = 2;
				while(a >= idx && b >= idx) {
					if (a % idx == 0 && b % idx == 0) {
						temp *= idx;
						a /= idx;
						b /= idx;
						continue;
					}
					idx++;
				}
				depth = temp;
			}
			int answer = 0;
			for (int i = 0; i < arr.size() - 1; i++) {
				answer += (((arr.get(i + 1) - arr.get(i)) / depth) - 1);
			}
			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
