package 유형.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미국스타일.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2024/11/02
 */
public class 미국스타일 {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());

			for (int i = 0; i < T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				double value = Double.parseDouble(st.nextToken());
				String unit = st.nextToken();

				double convertedValue;
				String convertedUnit;

				switch (unit) {
					case "kg":
						convertedValue = value * 2.2046;
						convertedUnit = "lb";
						break;
					case "lb":
						convertedValue = value * 0.4536;
						convertedUnit = "kg";
						break;
					case "l":
						convertedValue = value * 0.2642;
						convertedUnit = "g";
						break;
					case "g":
						convertedValue = value * 3.7854;
						convertedUnit = "l";
						break;
					default:
						throw new IllegalArgumentException("Invalid unit");
				}

				System.out.printf("%.4f %s%n", convertedValue, convertedUnit);
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
