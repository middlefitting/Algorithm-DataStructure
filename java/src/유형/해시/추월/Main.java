package 유형.해시.추월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());

			ArrayList<String> carIn = new ArrayList<>();
			ArrayList<String> carOut = new ArrayList<>();

			HashSet<String> exceedSet = new HashSet<>();

			for (int i = 0; i < n; i++) {
				carIn.add(br.readLine());
			}


			for (int i = 0; i < n; i++) {
				carOut.add(br.readLine());
			}

			int inIdx = 0;
			for (int i = 0; i < n; i++) {

				while (inIdx < n && exceedSet.contains(carIn.get(inIdx))) {
					inIdx++;
				}

				if (inIdx == n) {
					break;
				}

				if (!carOut.get(i).equals(carIn.get(inIdx))) {
					exceedSet.add(carOut.get(i));
				} else {
					inIdx++;
				}
			}

			System.out.println(exceedSet.size());

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
