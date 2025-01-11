package 유형.구현.명장남정훈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int all = Integer.parseInt(st.nextToken());

			while (all-- > 0) {
				if (l > r) {
					r++;
				} else {
					l++;
				}
			}

			System.out.println(Math.min(l, r) * 2);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
