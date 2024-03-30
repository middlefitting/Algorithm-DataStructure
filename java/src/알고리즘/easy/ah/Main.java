package 알고리즘.easy.ah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String me = br.readLine();
			String doctor = br.readLine();
			if (me.length() >= doctor.length()) {
				System.out.println("go");
			} else {
				System.out.println("no");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
