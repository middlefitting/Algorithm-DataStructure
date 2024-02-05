package 단계별로풀어보기.약수소수와배수.약수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			ArrayList<Integer> collect = IntStream.rangeClosed(1, n)
				.filter((i) -> n % i == 0)
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));

			int result = collect.size() >= k ? collect.get(k - 1) : 0;
			System.out.println(result);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
