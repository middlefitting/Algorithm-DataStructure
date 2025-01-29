package 유형.구현.t24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine(), ":");

			int hx = Integer.parseInt(st.nextToken());
			int mx = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());


			st = new StringTokenizer(br.readLine(), ":");

			int hy = Integer.parseInt(st.nextToken());
			int my = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());

			int h = hy - hx;
			int m = my - mx;
			int s = sy - sx;

			if (s < 0) {
				s += 60;
				m -= 1;
			}

			if (m < 0) {
				m += 60;
				h -= 1;
			}

			if (h < 0) {
				h += 24;
			}

			String hs;
			String ms;
			String ss;

			if (h < 10) {
				hs = "0" + h;
			} else {
				hs = String.valueOf(h);
			}

			if (m < 10) {
				ms = "0" + m;
			} else {
				ms = String.valueOf(m);
			}

			if (s < 10) {
				ss = "0" + s;
			} else {
				ss = String.valueOf(s);
			}

			System.out.println(hs + ":" + ms + ":" + ss);


			System.out.println();


		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
