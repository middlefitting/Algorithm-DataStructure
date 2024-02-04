package 단계별로풀어보기.약수소수와배수.배수와약수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuffer answer = new StringBuffer();
			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (a == 0 && b == 0) {
					break;
				}
				if (a > b) {
					if (a % b > 0) {
						answer.append("neither\n");
					} else {
						answer.append("multiple\n");
					}
				}
				if (b > a) {
					if (b % a > 0) {
						answer.append("neither\n");
					} else {
						answer.append("factor\n");
					}
				}
			}
			System.out.print(answer);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
