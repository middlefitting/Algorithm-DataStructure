package 유형.해시.차집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			TreeSet<Integer> set = new TreeSet<>(
				Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

			int[] removes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			for (int remove : removes) {
				set.remove(remove);
			}

			int size = set.size();
			System.out.println(size);

			if (size > 0) {
				System.out.println(set.stream().map(String::valueOf).collect(Collectors.joining(" ")));
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
