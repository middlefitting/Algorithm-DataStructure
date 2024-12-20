package 유형.구현.eveysecondcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " : ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " : ");

			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());

			d -= a;
			e -= b;
			f -= c;

			if (f < 0) {
				f += 60;
				e -= 1;
			}

			if (e < 0) {
				e += 60;
				d -= 1;
			}

			if (d < 0) {
				d += 24;
			}

			System.out.println(d * 3600 + e * 60 + f);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
