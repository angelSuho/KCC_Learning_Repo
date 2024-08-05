package kosa.restaurant;

import java.util.Scanner;

public class Main {
	
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Order order = new Order();
		
		MenuItem[] menuItems = {
			new Appetizer("프랜치 토스트", 10000, "토스트 입니다.", 1000),
			new Appetizer("스프", 10000, "스프 입니다.", 150),
			new MainCourse("랍스타", 123000, "랍스타 입니다.", false),
			new MainCourse("셀러드", 123000, "셀러드 입니다.", true),
			new Dessert("푸딩", 5800, "푸딩 입니다.", false),
			new Dessert("케이크", 24000, "케이크 입니다.", false),
			new Dessert("초콜릿", 8900, "초콜릿 입니다.", false),
		};
		
		System.out.println("수호네 레스토랑 메뉴");
		System.out.println("=========================");
		for (int i = 1; i <= menuItems.length; i++) {
			System.out.println("번호 " + i + ")");
			menuItems[i - 1].print();
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		}
		System.out.println();
		
		while(true) {
			System.out.println("1.주문추가 2.주문삭제 3.주문 결제 4.총매출 합계 5.종료");
			System.out.print("옵션 입력: ");
			String input = sc.nextLine();
			switch(input) {
				case "1":
					System.out.print("주문 메뉴 선택: ");
					String menu = sc.nextLine();
					for (MenuItem menuItem: menuItems) {
						if (menuItem.getName().equals(menu) ) {
							order.addOrder(menuItem);
							break;
						}
					}
					System.out.println("주문 완료");
					break;
				case "2":
					System.out.print("삭제 주문 선택: ");
					menu = sc.nextLine();
					order.removeOrder(menu);
					break;
				case "3":
					order.pay();
					System.out.println("주문 결제 완료");
					break;
				case "4":
					System.out.println("총 매출 합계: " + Order.getDayTotalPrice() + "원");
					break;
				case "5":
					return;
			}
		}
	}
}
