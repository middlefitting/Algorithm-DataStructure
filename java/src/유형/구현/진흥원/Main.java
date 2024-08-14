package 유형.구현.진흥원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			HashMap<String, String> map = new HashMap<>();
			map.put("Algorithm", "204");
			map.put("DataAnalysis", "207");
			map.put("ArtificialIntelligence", "302");
			map.put("CyberSecurity", "B101");
			map.put("Network", "303");
			map.put("Startup", "501");
			map.put("TestStrategy", "105");

			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				System.out.println(map.get(br.readLine()));
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
