package 유형.투포인터.좋다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			HashMap<Integer, Deque<Integer>> map = new HashMap<>();
			HashSet<Integer> goods = new HashSet<>();

			for (int i = 0; i < n; i++) {
				if (map.getOrDefault(arr[i], null) == null) {
					map.put(arr[i], new LinkedList<>());
				}
				map.getOrDefault(arr[i], null).add(i);
			}

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int temp = arr[i] + arr[j];
					Deque<Integer> indexList = map.getOrDefault(temp, null);
					if (indexList == null) {
						continue;
					}
					int size = indexList.size();
					for (int k = 0; k < size; k++) {
						int idx = indexList.pollFirst();
						if (idx == i || idx == j) {
							indexList.addLast(idx);
							continue;
						}
						goods.add(idx);
					}
				}
			}
			System.out.println(goods.size());
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}

