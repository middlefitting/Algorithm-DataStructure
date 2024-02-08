package 단계별로풀어보기.약수배수와소수2.다음소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static long findSoSu(long x) {
		long result = x;
		if (x < 2L) {
			return 2L;
		}
		while (true) {
			boolean flag = true;
			for (long i = 2; i <= (long) Math.sqrt(result); i++) {
				if (result % i == 0) {
					result++;
					flag = false;
					break;
				}
			}
			if (!flag) {
				continue;
			}
			break;
		}
		return result;
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long n = Long.parseLong(br.readLine());
			StringBuffer sb = new StringBuffer();
			for (long i = 0; i < n; i++) {
				long x = Long.parseLong(br.readLine());
				sb.append(findSoSu(x));
				sb.append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
