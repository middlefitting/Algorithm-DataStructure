package 유형.구현.lunacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringBuilder sb = new StringBuilder();
			while (true) {

				double d = Double.parseDouble(br.readLine());

				if (d == -1.0) {
					break;
				}

				double dar = d * 0.167;
				String formattedD = String.format("%.2f", d);
				String formattedDar = String.format("%.2f", dar);
				sb.append("Objects weighing ").append(formattedD).append(" on Earth will weigh ").append(formattedDar).append(" on the moon.\n");
			}

			System.out.print(sb);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
