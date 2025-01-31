package 유형.구현.rollindice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2025/01/31
 */
public class Main {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			int cnt = 0;

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (i + j == 10) {
						cnt++;
					}
				}
			}

			String way = " is " + cnt + " way ";
			if (cnt != 1) {
				way = " are " + cnt + " ways ";
			}

			System.out.println("There" + way + "to get the sum 10.");
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
