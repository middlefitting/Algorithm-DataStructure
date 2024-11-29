package 유형.그리디.사과담기게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int s = 1;
			int e = s + m - 1;

			int result = 0;
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int applePos = Integer.parseInt(br.readLine());
				if (e < applePos) {
					int mx = applePos - e;
					result += mx;
					s += mx;
					e += mx;
				} else if(s > applePos) {
					int mx = s - applePos;
					result += mx;
					s -= mx;
					e -= mx;
				}
			}

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
