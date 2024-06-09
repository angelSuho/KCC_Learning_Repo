package kosa.mission04;

import kosa.mission04.category.MainCategory;
import kosa.mission04.category.SubCategory;
import kosa.mission04.order.Option;
import kosa.mission04.order.Order;
import kosa.mission04.order.OrderItem;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        /**
         * 흐름
         * 고객 등록 하기
         * 상품 등록 하기
         * 상품 카테고리별 목록 보기
         * 상품 주문 하기
         * 개별 주문 목록 보기
         */

        /**
         * 해야할 일
         * --- valid (phoneNumber 중복같은거) ---
         * --- 상속 고민해보기 --- 해결
         * --- 자료구조 고민해보기 ---
         * 리팩토링 하기
         * 출력화면 이쁘게 만들기
         * 클래스 다이어그램 보충하기
         * 정규 표현식
         * PPT 만들기
         */

        /**
         * 시연 상황
         * 회원가입
         * 상품 등록 실패 => Admin 아님
         * 상품 카테고리 조회
         * 상품 주문 (여러 개): 그래픽 스웨트셔츠/m/2,맨투맨 center/s/1
         * 개별 주문 목록 보기
         * 총 매출액 확인 실패 => Admin 아님
         * 로그아웃
         * Admin 로그인    010-4212-5212
         * 상품 등록
         * 총 매출액 확인
         * 로그아웃
         * 종료
         * */

        Scanner sc = InputWriter.getScanner();
        Mall mall = new Mall();

        System.out.println("==================================================");
        System.out.println("               영호샾에 잘 오셨습니다");
        System.out.println("==================================================");

        while (true) {
            System.out.print("\033[1;92m[1].로그인 [2].회원가입 [3].종료: \033[0m ");
            int input = safeIntegerInput(sc);

            if (input == 3) {
                System.out.println("종료합니다.");
                return;
            }

            Customer customer = null;
            switch (input) {
                case 1:
                    customer = loginProcess(sc, mall);
                    break;
                case 2:
                    customer = registerCustomerProcess(sc, mall);
                    mall.addCustomer(customer);
                    break;
            }

            while (customer != null) {
                System.out.print("\033[1;92m1.상품 등록 2.상품 카테고리별 목록 보기 3.상품 주문 4.개별 주문 목록 보기 5.총 매출액 확인 6.로그아웃:\033[0m ");
                int num = safeIntegerInput(sc);
                try {
                    switch (num) {
                        case 1:
                            customer.checkAdmin();
                            registerProductProcess(sc, mall);
                            break;
                        case 2:
                            getSubCategoryList(sc, mall);
                            break;
                        case 3:
                            placeOrderProcess(sc, mall, customer);
                            break;
                        case 4:
                            mall.printOrders();
                            break;
                        case 5:
                            customer.checkAdmin();
                            System.out.printf("\033[1;93m총 판매 금액: %d원\033[0m", mall.getTotalAmount());
                            break;
                        case 6:
                            customer = null;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static int safeIntegerInput(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\033[1;91m잘못된 입력입니다. 다시 입력해주세요.\033[0m");
                System.out.print("\033[1;93m입력: \033[0m");
            }
        }
    }

    private static Customer loginProcess(Scanner sc, Mall mall) {
        System.out.print("전화번호를 입력해주세요. : ");
        String phoneNumber = sc.nextLine().trim();
        try {
            return mall.customerLogin(phoneNumber);
        } catch (Exception e) {
            System.out.println("\033[1;91m" + e.getMessage() + "\033[0m");
            return null;
        }
    }

    private static Customer registerCustomerProcess(Scanner sc, Mall mall) throws Exception {
        System.out.print("고객의 이름을 입력해주세요: ");
        String name = sc.nextLine().trim();
        if (!isValidName(name)) {
            throw new Exception("\033[1;91m이름은 2자에서 7자 사이, 특수문자 없어야합니다.\033[0m");
        }

        System.out.print("고객의 핸드폰 번호를 입력해주세요: ");
        String phoneNumber = sc.nextLine().trim();
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new Exception("\033[1;91m올바른 형식의 번호를 입력해주세요 (예: 010-1234-5678).\033[0m");
        }
        if (mall.isDuplicatePhoneNumber(phoneNumber)) {
            throw new Exception("\033[1;91m이미 가입된 번호입니다.\033[0m");
        }

        System.out.print("고객의 생년월일을 입력해주세요 (예: 960120): ");
        String birth = sc.nextLine().trim();
        if (!isValidBirth(birth)) {
            throw new Exception("\033[1;91m생년월일은 6자리 숫자여야 합니다 (예: 960120).\033[0m");
        }

        return new Customer(name, birth, phoneNumber);
    }

    private static boolean isValidName(String name) {
        return name.matches("[\\p{Alpha}0-9ㄱ-힣]{2,7}");
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^01(?:0|1)-(\\d{3,4})-\\d{4}$");
    }

    private static boolean isValidBirth(String birth) {
        return birth.matches("\\d{6}");
    }

    private static void placeOrderProcess(Scanner sc, Mall mall, Customer customer) {
        try {
            System.out.print("상품 이름 입력: ");
            String[] split = sc.nextLine().split(",");
            List<OrderItem> orderItems = new ArrayList<>();
            for (String s : split) {
                String[] str = s.split("/");    // idx: [0] 상품명 [1] 사이즈 [2] 수량
                List<String> inputs = Arrays.asList(str);
                orderItems.add(new OrderItem(mall.validProductName(inputs), inputs.get(1), Long.parseLong(inputs.get(2))));
            }
            System.out.print("주문 방법 입력 /== 계좌 현금 카드 ==/ ");
            String type = sc.nextLine();

            Order order = new Order("ORD_" + Math.abs(UUID.randomUUID().getLeastSignificantBits()), customer, Option.getOption(type), orderItems);
            mall.addOrder(order);
            System.out.println("\033[1;93m주문이 완료되었습니다!\033[0m"); //"\033[1;93m입력: \033[0m"
        } catch (Exception e) {
            System.out.println("오류: " + e.getMessage());
        }
    }

    private static void registerProductProcess(Scanner sc, Mall mall) throws Exception {
        SubCategory subCategory = handleCategoryProcess(sc, mall);
        // 상품 이름 입력
        System.out.print("상품의 이름을 입력해주세요: ");
        String name = sc.nextLine();
        if (mall.getProducts().stream().anyMatch(p -> p.getName().equals(name))) {
            throw new Exception("\"\\033[1;91m오류: 상품 이름은 중복될 수 없습니다.\\033[0m\"");
        }

        // 상품 가격 입력
        System.out.print("상품의 가격을 입력해주세요: ");
        int price = Integer.parseInt(sc.nextLine());

        // 상품 설명 입력
        System.out.print("상품의 설명을 입력해주세요: ");
        String description = sc.nextLine();

        // 상품 사이즈 및 수량 입력
        System.out.print("상품의 사이즈를 입력해주세요 (예: 100,105,110): ");
        String[] sizes = sc.nextLine().split(",");
        System.out.print("각 사이즈의 상품 개수를 순서대로 입력해주세요 (예: 1,2,3): ");
        String[] quantities = sc.nextLine().split(",");

        if (sizes.length != quantities.length) {
            throw new Exception("\033[1;91m오류: 사이즈의 개수와 수량의 개수가 일치해야 합니다.\033[1;91m");
        }

        Product product = new Product(name, price, description, subCategory);
        for (int i = 0; i < sizes.length; i++) {
            product.addSizeQuantity(sizes[i], Integer.parseInt(quantities[i]));
        }

        mall.addProduct(product);
        System.out.println("상품 등록이 완료되었습니다!");
    }

    private static void getSubCategoryList(Scanner sc, Mall mall) throws Exception {
        SubCategory subCategory = handleCategoryProcess(sc, mall);
        System.out.println("선택한 소분류의 상품 목록:");
        subCategory.printAll();
    }

    private static SubCategory handleCategoryProcess(Scanner sc, Mall mall) throws Exception {
        mall.printMainCategories();
        System.out.print("대분류 카테고리 이름을 입력해주세요: ");
        String mainCategoryName = sc.nextLine();
        MainCategory mainCategory = mall.getMainCategoryByName(mainCategoryName);
        mainCategory.printAll();

        System.out.print("소분류의 이름을 입력해주세요: ");
        String subCategoryName = sc.nextLine();
        return mall.getSubCategoryByName(subCategoryName);
    }
}
