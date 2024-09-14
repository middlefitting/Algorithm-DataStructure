package 유형.구현.코드마스터2023;

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
 * @since : 2024/09/14
 */
public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			if (s.equals("SONGDO")) {
				System.out.println("HIGHSCHOOL");
			} else if (s.equals("CODE")) {
				System.out.println("MASTER");
			} else if (s.equals("2023")) {
				System.out.println("0611");
			} else {
				System.out.println("CONTEST");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
