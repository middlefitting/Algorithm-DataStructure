package 유형.이진트리.대칭차집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			HashSet<Integer> setA = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toCollection(HashSet::new));

			HashSet<Integer> setB = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toCollection(HashSet::new));

			int commonCnt = 0;
			for (Integer element : setA) {
				if (setB.contains(element)) {
					commonCnt++;
				}
			}
			System.out.println(a - commonCnt + b - commonCnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
