package 알고리즘.easy.터널의입구와출구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int temp = Integer.parseInt(br.readLine());
			int result = temp;
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				temp += Integer.parseInt(st.nextToken());
				temp -= Integer.parseInt(st.nextToken());
				if (temp < 0) {
					result = 0;
					break;
				}
				result = Math.max(result, temp);
			}
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
