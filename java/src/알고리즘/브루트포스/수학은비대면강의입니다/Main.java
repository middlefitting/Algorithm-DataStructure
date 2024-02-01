package 알고리즘.브루트포스.수학은비대면강의입니다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Reader {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private Reader() {
		throw new RuntimeException();
	}

	public static ArrayList<Integer> readIntegerArray() {
		try {
			return Stream.of(br.readLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayList::new));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}

public class Main {
	public static void main(String args[]) {
		ArrayList<Integer> conditions = Reader.readIntegerArray();
		int a = conditions.get(0);
		int b = conditions.get(1);
		int c = conditions.get(2);
		int d = conditions.get(3);
		int e = conditions.get(4);
		int f = conditions.get(5);
		for (int x = -999; x <= 999; x++) {
			for(int y = -999; y <= 999; y++) {
				if (a * x + b * y == c && d * x +e * y == f) {
					System.out.print(x);
					System.out.print(" ");
					System.out.println(y);
				}
			}
		}
	}
}
