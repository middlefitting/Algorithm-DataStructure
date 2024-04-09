package 유형.문자열.나는친구가적다small;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static List<String> compare;
	private static List<String> str;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			compare = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
			str = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
			boolean b = ftStrIn(compare, str);
			if (b) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static boolean ftStrIn(List<String> compare, List<String> str) {
		int idx = 0;
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			set.add(String.valueOf(i));
		}
		while (idx < compare.size()) {
			int cdx = 0;
			for (int i = idx; i < compare.size(); i++) {
				if (cdx >= str.size()) {
					break;
				}
				if (str.get(cdx).equals(compare.get(i))) {
					cdx++;
					continue;
				}
				if (set.contains(compare.get(i))) {
					continue;
				}
				break;
			}
			if (cdx >= str.size()) {
				return true;
			}
			idx++;
		}
		return false;
	}
}
