package 유형.구현.저항;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			HashMap<String, Long> value = new HashMap<>();
			HashMap<String, Long> pow = new HashMap<>();

			value.put("black", 0L);
			value.put("brown", 1L);
			value.put("red", 2L);
			value.put("orange", 3L);
			value.put("yellow", 4L);
			value.put("green", 5L);
			value.put("blue", 6L);
			value.put("violet", 7L);
			value.put("grey", 8L);
			value.put("white", 9L);

			pow.put("black", 1L);
			pow.put("brown", 10L);
			pow.put("red", 100L);
			pow.put("orange", 1000L);
			pow.put("yellow", 10000L);
			pow.put("green", 100000L);
			pow.put("blue", 1000000L);
			pow.put("violet", 10000000L);
			pow.put("grey", 100000000L);
			pow.put("white", 1000000000L);

			System.out.println((value.get(br.readLine()) * 10 + value.get(br.readLine())) * pow.get(br.readLine()));

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
