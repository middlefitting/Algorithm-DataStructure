package 기하직사각형과삼각형.수학은체육과목입니다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long n = Long.parseLong(br.readLine());
			System.out.println(n * 4);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

