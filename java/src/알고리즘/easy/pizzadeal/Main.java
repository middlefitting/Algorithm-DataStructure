package 알고리즘.easy.pizzadeal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double a = Integer.parseInt(st.nextToken());
			double b = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			double c = Integer.parseInt(st.nextToken());
			double d = Integer.parseInt(st.nextToken());

			if (Math.PI * c * c / d > a / b) {

				System.out.println("Whole pizza");
			} else {
				System.out.println("Slice of pizza");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
