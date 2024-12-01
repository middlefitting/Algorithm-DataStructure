package 유형.해시.중복빼고정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			br.readLine();
			System.out.println(Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(HashSet::new)).stream()
				.sorted().map(String::valueOf).collect(Collectors.joining(" ")));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
