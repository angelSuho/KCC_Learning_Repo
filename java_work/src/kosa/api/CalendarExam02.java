package kosa.api;

import java.util.Calendar;

public class CalendarExam02 {
	public static void main(String[] args) {
		// 2024 6월 달력 만들기
		Calendar gc = Calendar.getInstance();
		int year = 2024;
		int month = 5;	// index 0부터 시작 (ex: 1월 index=0)
		int day = 1;
		
		gc.set(year, month, day);
		System.out.println("<" + year + "년 " + (month+1) + "월 달력>");
		System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토");
		
		for (int i = 0; i < gc.get(Calendar.DAY_OF_WEEK) - 1; i++)
			System.out.print("\t");
		
		int cnt = 0;
		while(++cnt <= gc.getActualMaximum(Calendar.DATE)) {
			System.out.printf("%2d\t", cnt);
			if (gc.get(Calendar.DAY_OF_WEEK) == 7) System.out.println();
			gc.add(Calendar.DATE, 1);
		}
	}
}
