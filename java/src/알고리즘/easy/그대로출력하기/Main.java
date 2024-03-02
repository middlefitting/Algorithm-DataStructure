package 알고리즘.easy.그대로출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String temp;
			while (true) {
				temp = br.readLine();
				if (temp != null) {
					System.out.println(temp);
				} else {
					break;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
