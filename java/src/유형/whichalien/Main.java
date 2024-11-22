package 유형.whichalien;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());

			String result = "";

			if (a >= 3 && b <= 4) {
				result += "TroyMartian\n";
			}
			if (a <= 6 && b >= 2) {
				result += "VladSaturnian\n";
			}
			if (a <= 2 && b <= 3) {
				result += "GraemeMercurian\n";
			}

			System.out.print(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
