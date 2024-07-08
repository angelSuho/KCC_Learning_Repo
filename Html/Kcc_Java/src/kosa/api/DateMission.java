package kosa.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateMission {
	public static void main(String[] args) {
		// 키보드 -> 날짜 입력 2014/06/04
		// 입사일을 입력받아 -> 몇년 몇개월 재직중인지
		Scanner sc = new Scanner(System.in);
		
		Date date = null;
		while(true) {
			System.out.print("입사일 입력: ");
			String input = sc.nextLine();
			
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			try {
				date = df.parse(input);
				break;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				System.out.println("잘못된 입사일 입니다. (yyyy/MM/dd)");
			}
		}
		
		Date now = new Date();

        // 연과 월 차이 계산
        int yearDiff = now.getYear() - date.getYear();
        int monthDiff = now.getMonth() - date.getMonth();

        if (monthDiff < 0) {
            yearDiff--;
            monthDiff += 12;
        }

        // 결과 출력
        if (monthDiff == 0) {
        	System.out.println(yearDiff + "년 재직중");
        } else {
        	System.out.println(yearDiff + "년 " + monthDiff + "개월 재직중");
        }
	}
}
