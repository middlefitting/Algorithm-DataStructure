package 유형.구현.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int per = 0;
			int as = 0;

			int perOut = 0;
			int asOut = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			int home = Integer.parseInt(st.nextToken());
			int out = Integer.parseInt(st.nextToken());

			per += home;
			as += out;
			asOut += out;

			st = new StringTokenizer(br.readLine());
			home = Integer.parseInt(st.nextToken());
			out = Integer.parseInt(st.nextToken());

			as += home;
			per += out;
			perOut += out;

			if (per > as) {

				System.out.println("Persepolis");
			} else if (per < as) {

				System.out.println("Esteghlal");
			} else {

				if (perOut > asOut) {

					System.out.println("Persepolis");
				} else if (perOut < asOut) {

					System.out.println("Esteghlal");
				} else {

					System.out.println("Penalty");
				}
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
