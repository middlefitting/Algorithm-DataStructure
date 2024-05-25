package 유형.구현.이천칠년;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			System.out.println(DateParser.getWeekday(m, d));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static class DateParser {
		private static final String[] weekdays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		private static final int[] monthDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		private static String getWeekday(int month, int day) {
			for (int i = 1; i < month; i++) {
				day += monthDay[i];
			}
			return weekdays[day % 7];
		}
	}
}
