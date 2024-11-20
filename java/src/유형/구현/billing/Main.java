package 유형.구현.billing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Main.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2024/11/20
 */
public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			HashMap<String, Double> map = new HashMap<>();
			map.put("Paper", 57.99);
			map.put("Printer", 120.50);
			map.put("Planners", 31.25);
			map.put("Binders", 22.50);
			map.put("Calendar", 10.95);
			map.put("Notebooks", 11.20);
			map.put("Ink", 66.95);

			double result = 0;

			while (true) {
				String s = br.readLine();

				if (s.equals("EOI")) {
					break;
				}
				result += map.get(s);
			}

			System.out.println("$" + String.format("%.2f", result));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
