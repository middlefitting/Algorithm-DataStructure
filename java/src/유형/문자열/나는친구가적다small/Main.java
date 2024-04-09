package 유형.문자열.나는친구가적다small;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static List<String> compare;
	private static List<String> str;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			compare = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
			str = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
			ftStrIn(compare, str);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static boolean ftStrIn(List<String> compare, List<String> str) {
		for (int i = 0; i < compare.size(); i++) {
			boolean flag = true;
			int idx = i;
			for (int j = 0; j < str.size(); j++) {
				while (idx < compare.size()) {
					if (compare.get(idx).equals(str.get(idx))) {
						break;
					}
					idx++;
				}
			}
			if (flag) {
				return true;
			}
		}
		return false;
	}
}
