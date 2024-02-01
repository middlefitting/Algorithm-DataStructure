package 알고리즘.브루트포스.배열돌리기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Reader {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private Reader() {
		throw new RuntimeException();
	}

	public static ArrayList<Integer> readIntegerLine() {
		try {
			return Stream.of(br.readLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayList::new));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}

class Logic {
	int n;
	int m;
	int k;
	int answer = Integer.MAX_VALUE;
	ArrayList<ArrayList<Integer>> arr;
	ArrayList<ArrayList<Integer>> rotate;

	public Logic(int n, int m, int k, ArrayList<ArrayList<Integer>> arr, ArrayList<ArrayList<Integer>> rotate) {
		this.n = n;
		this.m = m;
		this.k = k;
		this.arr = arr;
		this.rotate = rotate;
	}


}

public class Main {
	public static void main(String args[]) {
		ArrayList<Integer> conditions = Reader.readIntegerLine();
		int n = conditions.get(0);
		int m = conditions.get(1);
		int k = conditions.get(2);
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		ArrayList<ArrayList<Integer>> rotates = new ArrayList<>();
		IntStream.of(n).forEach((i) -> arr.add(Reader.readIntegerLine()));
		IntStream.of(k).forEach((i) -> rotates.add(Reader.readIntegerLine()));


	}
}
