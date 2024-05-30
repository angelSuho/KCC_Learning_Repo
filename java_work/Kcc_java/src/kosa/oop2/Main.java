package kosa.oop2;

import java.util.Scanner;

public class Main {
	
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Store searchStore = null;
		
		Manager manager = new Manager();		
		initializeManager(manager);
		User user = getUserAndInputUserProcess();
				
		System.out.println("\n오늘의 점심 메뉴");
		System.out.println("===================");
		manager.stores.forEach(store -> store.findAll());
		 
		boolean isFlag = true;
		while(isFlag) {
			try {
				System.out.println("===================");
				System.out.print("가게 선택: ");
				String inputStoreTitle = sc.nextLine();
				searchStore = manager.searchStore(inputStoreTitle);
				isFlag = false;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		isFlag = true;
		while(isFlag) {
			try {
				searchStore.getLunchList().forEach(lunch -> lunch.printLunch());
				System.out.println("===================");
				System.out.print("메뉴 선택: ");
				String inputLunchTitle = sc.nextLine();
				Lunch searchLunch = searchStore.findByName(inputLunchTitle);
				
				if (searchLunch != null) {
					if (user.validateLunchPrice(searchLunch.getPrice())) {
						System.out.println("===================");
						System.out.println("오늘의 메뉴는!");
						searchLunch.printLunch();
						
						System.out.println("잔액: " + 
						(user.getBalance() - searchLunch.getPrice()) + "원");
						System.out.println(user.getName() + "님 식사 맛있게 하세요!");
						isFlag = false;
					}
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static User getUserAndInputUserProcess() {
		System.out.print("이름을 입력해주세요: ");
		String name = sc.nextLine();
		System.out.print("사용할 수 있는 금액을 입력해주세요: ");
		Long balance = Long.parseLong(sc.nextLine());		
		return new User(name, balance);
	}

	private static void initializeManager(Manager manager) {
		String mcDonald = "맥도날드";
		String genrokuUdon = "겐로쿠 우동";
		String hongKongStore = "홍콩반점";
		Store store1 = new Store(mcDonald, "서울시 명륜동");
		store1.registerLunch(new Lunch("맥스파이시버거", 7_000L));		
		store1.registerLunch(new Lunch("불고기버거", 5_000L));
		
		Store store2 = new Store(genrokuUdon, "서울시 명륜동");
		store2.registerLunch(new Lunch("치킨 우동", 10_000L));		
		store2.registerLunch(new Lunch("챠슈 우동", 11_000L));
		
		Store store3 = new Store(hongKongStore, "서울시 명륜동");
		store3.registerLunch(new Lunch("짜장면", 5_000L));		
		store3.registerLunch(new Lunch("짬뽕", 6_000L));
		store3.registerLunch(new Lunch("볶음밥", 7_000L));
		
		manager.registerStore(store1);
		manager.registerStore(store2);
		manager.registerStore(store3);
	}
}
