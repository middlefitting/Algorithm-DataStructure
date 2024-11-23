package 유형.bodymassindex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			double weight = Double.parseDouble(br.readLine());

			double per = Double.parseDouble(br.readLine());

			if (weight / (per * per) > 25.0) {

				System.out.println("Overweight");
			} else if (weight / (per * per) >= 18.5) {
				System.out.println("Normal weight\n");
			} else {
				System.out.println("Underweight");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
