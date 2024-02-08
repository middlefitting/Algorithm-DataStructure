package 약수배수와소수2.골드바흐파티션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			boolean[] gold = new boolean[1000001];
			for (int i = 2; i <= 1000000; i++) {
				gold[i] = true;
			}
			for (int i = 2; i <= 1000000; i++) {
				if (!gold[i]) {
					continue;
				}
				int idx = 2;
				while (idx * i <= 1000000) {
					gold[i * idx] = false;
					idx++;
				}
			}

			StringBuffer sb = new StringBuffer();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(br.readLine());
				int result = 0;
				for (int j = 2; j <= x / 2; j++) {
					if (gold[j] && gold[x - j]) {
						result++;
					}
				}
				sb.append(result);
				sb.append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

