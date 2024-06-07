package kosa.mission04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
         * valid (phoneNumber 중복같은거)
         * 상속 고민해보기
         * 자료구조 고민해보기
         * 리팩토링 하기
         * 출력화면 이쁘게 만들기
         * 클래스 다이어그램 보충하기
         * PPT 만들기
         */

        Scanner sc = InputWriter.getScanner();
        Mall mall = new Mall();

        while (true) {
            System.out.print("1.로그인 2.회원가입 3.종료 :");
            Customer customer = null;

            int input = Integer.parseInt(sc.nextLine());
            switch (input) {
                case 1:
                    try {
                        System.out.println("전화번호를 입력해주세요.");
                        String phoneNumber = sc.nextLine();
                        customer = mall.customerLogin(phoneNumber);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Customer registerCustomer = registerCustomerProcess(sc);
                        mall.addCustomer(registerCustomer);
                        customer = registerCustomer;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("종료합니다.");
                    return;
            }
            while (customer != null) {
                System.out.print("1.상품 등록 2.상품 카테고리별 목록 보기 3.상품 주문 4.개별 주문 목록 보기 5.로그아웃 : ");
                int num = Integer.parseInt(sc.nextLine());
                switch (num) {
                    case 1:
                        try {
                            customer.checkAdmin();
                            registerProductProcess(sc, mall);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try{
                            getSubCategoryList(sc, mall);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("상품 이름 입력: ");
                            String[] split = sc.nextLine().split(",");
                            List<String> inputs = Arrays.asList(split);

                            List<Product> products = mall.validProductName(inputs);
                            System.out.println("주문 방법 입력: " + Option.ACCOUNT.getType() + " " + Option.CASH.getType() + " " + Option.CARD.getType());
                            String type = sc.nextLine();
                            Order order = new Order("ORD_"+UUID.randomUUID().getLeastSignificantBits(), customer, Option.getOption(type), products);
                            mall.addOrder(order);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        mall.printOrders();
                        break;
                    case 5:
                        customer = null;
                        break;

                }
            }


        }
    }

    private static void registerProductProcess(Scanner sc, Mall mall) throws Exception {
        SubCategory subCategory = handleCategoryProcess(sc, mall);
        System.out.print("상품의 이름을 입력해주세요 : ");
        String name = sc.nextLine();
        System.out.print("상품의 가격을 입력해주세요 : ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("상품의 설명을 입력해주세요 : ");
        String description = sc.nextLine();

        Product product = new Product(name, price, description, subCategory);
        subCategory.addProduct(product);
        mall.addProduct(product);
    }

    private static void getSubCategoryList(Scanner sc, Mall mall) throws Exception {
        SubCategory subCategory = handleCategoryProcess(sc, mall);
        subCategory.printAll();
    }

    private static SubCategory handleCategoryProcess(Scanner sc, Mall mall) throws Exception {
        mall.printMainCategories();
        System.out.print("대분류의 이름을 입력해주세요 : ");
        String mainCategoryName = sc.nextLine();
        MainCategory mainCategoryByName = mall.getMainCategoryByName(mainCategoryName);
        mainCategoryByName.printSubCategory();
        System.out.print("소분류의 이름을 입력해주세요: ");
        String subCategoryName = sc.nextLine();
        return mall.getSubCategoryByName(subCategoryName);
    }

    private static Customer registerCustomerProcess(Scanner sc) throws Exception {
        System.out.print("고객의 이름을 입력해주세요: ");
        String nickname = sc.nextLine();
        if (!isValidName(nickname)) throw new Exception("이름은 7자리 이내에 특수문자가 없어야합니다.");

        System.out.print("고객의 핸드폰 번호을 입력해주세요: ");
        String phoneNumber = sc.nextLine();
        if (!isValidNPhoneNumber(phoneNumber)) throw new Exception("번호를 정확히 입력해주세요.");

        System.out.print("고객의 생년월일을 입력해주세요 ex)000112 : ");
        String birth = sc.nextLine();
        if (!isValidBirth(birth)) throw new Exception("생년월일은 6자리 입니다. ex)960120");

        return new Customer(nickname, birth, phoneNumber);
    }

    private static boolean isValidName(String name) {
        String reg = "^[\\p{Alpha}0-9ㄱ-힣]{2,7}$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private static boolean isValidNPhoneNumber(String phoneNumber) {
        String reg = "^01(?:0|1)-(\\d{3,4})-\\d{4}$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private static boolean isValidBirth(String birth) {
        String reg = "[0-9]{6}$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(birth);
        return matcher.matches();
    }
}