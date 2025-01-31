package 유형.구현.tv크기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			double diagonal = Double.parseDouble(st.nextToken());
			double row = Double.parseDouble(st.nextToken());
			double col = Double.parseDouble(st.nextToken());

			double x = Math.sqrt(diagonal * diagonal / (row * row + col * col));

			System.out.println((int) Math.floor(row * x) + " " + (int) Math.floor(col * x));

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
