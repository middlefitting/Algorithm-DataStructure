package 유형.구현.rats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n12 = Integer.parseInt(st.nextToken());

			System.out.println(Math.abs((n1 + 1) * (n2 + 1) / (n12 + 1) - 1));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
