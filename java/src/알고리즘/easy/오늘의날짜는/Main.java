package 알고리즘.easy.오늘의날짜는;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Main {
	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
		System.out.println(now.getYear());
		int monthValue = now.getMonthValue();
		if (monthValue < 10) {
			System.out.println("0" + monthValue);
		} else {
			System.out.println(monthValue);
		}
		int dayOfMonth = now.getDayOfMonth();
		if (dayOfMonth < 10) {
			System.out.println("0" + dayOfMonth);
		} else {
			System.out.println(dayOfMonth);
		}
	}
}
