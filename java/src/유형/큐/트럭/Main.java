package 유형.큐.트럭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int bridgeLen = Integer.parseInt(st.nextToken());
			int maxHeight = Integer.parseInt(st.nextToken());

			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			Queue<Integer> bridge = new LinkedList<>();
			IntStream.range(0, bridgeLen).forEach((i) -> bridge.add(0));
			int tempWeight = 0;

			int idx = 0;
			int clock = 0;
			while (idx < n) {
				tempWeight -= bridge.poll();
				if (tempWeight + arr[idx] > maxHeight) {
					bridge.add(0);
				} else {
					bridge.add(arr[idx]);
					tempWeight += arr[idx];
					idx++;
				}
				clock++;
			}

			while (!bridge.isEmpty()) {
				clock++;
				bridge.poll();
			}

			System.out.println(clock);

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
