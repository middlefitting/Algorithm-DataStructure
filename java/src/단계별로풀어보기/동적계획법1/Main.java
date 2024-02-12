package 단계별로풀어보기.동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> arr = new ArrayList<>();
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					Integer a = Integer.parseInt(st.nextToken());
					Integer b = Integer.parseInt(st.nextToken());
					arr.add(a);
					map.put(a, b);
				}
			arr = arr.stream().sorted().collect(Collectors.toList());
			int[] targets = arr.stream().mapToInt(map::get).toArray();
			int[] lis = new int[n + 1];
			Arrays.fill(lis, 1);
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (targets[i] > targets[j]) {
						lis[i] = Math.max(lis[i], lis[j] + 1);
					}
				}
			}

			System.out.println(n - Arrays.stream(lis).max().orElse(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
