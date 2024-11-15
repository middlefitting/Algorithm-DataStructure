package 유형.구현.인간은무엇인가;

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
 * @since : 2024/11/16
 */
public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			if (n <= 100000 && (n % 2024 == 0)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
