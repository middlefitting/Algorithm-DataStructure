package 알고리즘.easy.엘리스트랙매칭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			List<String> arr = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
			String me = br.readLine();
			int answer = 0;
			for (String temp : arr) {
				if (temp.equals(me)) {
					answer++;
				}
			}
			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
