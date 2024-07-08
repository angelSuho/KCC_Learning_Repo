package kosa.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class QueueMission {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long totalSales = 0;
		List<Food> foods = List.of(
				new Food("파스타", 13_000),
				new Food("치킨", 20_000),
				new Food("랍스타", 22_000),
				new Food("스프", 8_000));
		
		Queue<Order> queueOrders = new LinkedList<>();
		while(true) {
			System.out.println("1.주문요청 2.주문처리 3.미 결제 주문내역 출력 4.매출액 총액 5.종료");
			System.out.print("메뉴 입력: ");
			int input = Integer.parseInt(sc.nextLine());
			switch(input) {
				case 1:
					System.out.println("메뉴를 골라주세요");
					for (Food food : foods) {
						food.printFood();
					}
					System.out.print("선택: ");
					String[] orders = sc.nextLine().split(", ");
					
					Order order = new Order();
					for (String o : orders) {
						for (Food food : foods) {
							if (o.equals(food.getFoodName())) {
								order.addOrder(food);
							}
						}
					}
					queueOrders.add(order);
					break;
				case 2:
					if (queueOrders.isEmpty()) {
						System.out.println("주문 요청된 사항이 없습니다.");
					} else {
						Order pollOrder = queueOrders.poll();
						totalSales += pollOrder.getAmount();
						System.out.println("한건의 주문이 완료 되었습니다.");
					}
					break;
				case 3:
					System.out.println("미 결제된 주문 내역");
					for (Order order1 : queueOrders) {
						order1.printOrder();
					}
					break;
				case 4:
					System.out.println("매출액 총액: " + totalSales + "원");
					break;
				case 5:
					System.out.println("시스템 종료");
					return;
			}
		}
	}
}
