package 단계별로풀어보기.일반수학.진법변환2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int formation = Integer.parseInt(st.nextToken());
			System.out.println(Integer.toString(num, formation).toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



