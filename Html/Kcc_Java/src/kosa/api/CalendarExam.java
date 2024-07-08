package kosa.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarExam {
	public static void main(String[] args) {
//		GregorianCalendar gc = new GregorianCalendar();
		
		Calendar gc = Calendar.getInstance();
		System.out.println(gc);
		
		String now = gc.get(Calendar.YEAR) + "년 " + 
					(gc.get(Calendar.MONTH) + 1) + "월 " + 
					gc.get(Calendar.DATE) + "일 " +
					gc.get(Calendar.HOUR) + "시 " + 
					gc.get(Calendar.MINUTE) + "분";
		
		System.out.println("현재시간: " + now);
		gc.add(Calendar.DATE, 100);
		String future = gc.get(Calendar.YEAR) + "년 " + 
				(gc.get(Calendar.MONTH) + 1) + "월 " + 
				gc.get(Calendar.DATE) + "일 " +
				gc.get(Calendar.HOUR) + "시 " + 
				gc.get(Calendar.MINUTE) + "분";
	
		System.out.println("현재시간: " + future);
		gc.set(2022, 5, 4);
		gc.add(Calendar.DATE, 1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String str = sdf.format(gc.getTime());
		System.out.println(str);
		
		// 퀴즈: 2024 ~ 2030년까지 자신의 생일이 무슨 요일?
		// Calendar.DAY_OF_WEEK -> 요일 <일(1) 월(2) 화(3) 수(4) 목(5) 금(6) 토(7)>
		gc.set(2024, 2, 3);
		for (int i = 0; i < 6; i++) {
			printDays(gc.get(Calendar.DAY_OF_WEEK), sdf.format(gc.getTime()));
			gc.add(Calendar.YEAR, 1); // 2025
		}
		printDays(gc.get(Calendar.DAY_OF_WEEK), sdf.format(gc.getTime()));
	}
	
	private static void printDays(int i, String sdf) {
		switch(i) {
		case 1:
			System.out.println(sdf + " 일요일");
			break;
		case 2:
			System.out.println(sdf + " 월요일");
			break;
		case 3:
			System.out.println(sdf + " 화요일");
			break;
		case 4:
			System.out.println(sdf + " 수요일");
			break;
		case 5:
			System.out.println(sdf + " 목요일");
			break;
		case 6:
			System.out.println(sdf + " 금요일");
			break;
		case 7:
			System.out.println(sdf + " 토요일");
			break;
		}
	}
}
