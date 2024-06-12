package kosa.mission04;

import kosa.mission04.category.Category;
import kosa.mission04.category.MainCategory;
import kosa.mission04.category.SubCategory;
import kosa.mission04.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mall {
    private List<Customer> customers;
    private List<Order> orders;
    private List<Product> products;
    private long totalAmount;
    private List<Category> mainCategories;

    public Mall() {
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.products = new ArrayList<>();
        this.totalAmount = 0;
        this.mainCategories = new ArrayList<>();
        
        initCategory();
        initProducts();
        initAdmin();
    }

    public List<Product> getProducts() {
        return products;
    }

    public MainCategory getMainCategoryByName(String name) throws Exception {
    	return (MainCategory) mainCategories.stream()
    			.filter(c -> c.getName().equals(name))
    			.findFirst()
    			.orElseThrow(() -> new Exception("\033[1;91m대분류 카테고리의 이름이 알맞지 않습니다.\033[0m"));
    }

    public Customer customerLogin(String phoneNumber) throws Exception {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                if (customer.getRole().equals(Role.ADMIN)) {
                    System.out.println("관리자님 환영합니다.\n");
                }
                
                return customer;
            }
        }

        throw new Exception("\033[1;93m존재하지 않는 회원입니다.\033[0m");
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addOrder(Order order) {
        this.totalAmount += order.getOrderAmount();
        this.orders.add(order);
    }

    public void addMainCategories(List<MainCategory> categories) {
        this.mainCategories.addAll(categories);
    }

    public void printMainCategories() {
        System.out.println("대분류 카테고리 이름 : ");
        
        mainCategories.stream().forEach(c -> {
        	System.out.println(c.getName());
            System.out.println("---------------");
        });
    }

    public Product validProductName(List<String> option) throws Exception {
        for (Product p : this.products) {
            boolean isValidProductName = p.getName().equals(option.get(0));
            boolean isRemainQuantity = !p.getSizeQuantities().isEmpty() && p.getSizeQuantities().get(option.get(1)) >= Integer.parseInt(option.get(2));
            if (isValidProductName && isRemainQuantity) {
                return p;
            } else if (!p.getSizeQuantities().isEmpty() && p.getSizeQuantities().get(option.get(1)) < Integer.parseInt(option.get(2))) {
                throw new Exception("\033[1;91m재고가 부족합니다.\033[0m");
            }
        }
        throw new Exception("제품명을 정확하게 입력해주세요.\033[0m");
    }

    public SubCategory getSubCategoryByName(String name) throws Exception {
        for (Category mainCategory : mainCategories) {
            List<SubCategory> subCategories = ((MainCategory) mainCategory).getSubCategories();
            return subCategories.stream()
            		.filter(s -> s.getName().equals(name))
            		.findFirst().get();
        }

        throw new Exception("\033[1;91m대분류 카테고리의 이름이 알맞지 않습니다.\033[0m");
    }

    public long getTotalAmount() {
        return this.totalAmount;
    }

    public void printOrders() {
        System.out.println("개별 주문 목록 보기");
        
        orders.stream().forEach(order -> {
        	order.printOrder();
            System.out.println("주문 금액: " + order.getOrderAmount() + "원");
            System.out.println("-------------");
        });
    }

    public boolean isDuplicatePhoneNumber(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private void initCategory() {
        List<MainCategory> categories = new ArrayList<>();
        MainCategory top = new MainCategory("상의");
        top.addSubCategories(List.of(
                new SubCategory("맨투맨/스웨트셔츠"),
                new SubCategory("셔츠/블라우스"),
                new SubCategory("후드 티셔츠"),
                new SubCategory("니트/스웨터"),
                new SubCategory("카라티셔츠")
        ));
        categories.add(top);

        MainCategory bottom = new MainCategory("하의");
        bottom.addSubCategories(List.of(
                new SubCategory("슈트 팬츠/슬랙스"),
                new SubCategory("트레이닝/조거 팬츠"),
                new SubCategory("숏 팬츠"),
                new SubCategory("롱 팬츠")
        ));
        categories.add(bottom);

        MainCategory outer = new MainCategory("아우터");
        outer.addSubCategories(List.of(
                new SubCategory("후드집업"),
                new SubCategory("블루종/MA-1"),
                new SubCategory("레더/라이더스 재킷"),
                new SubCategory("무스탕/퍼"),
                new SubCategory("트러거 재킷")
        ));
        categories.add(outer);

        addMainCategories(categories);
    }

    private void initProducts() {
        Random random = new Random();

        SubCategory mantoman = ((MainCategory) mainCategories.get(0)).getSubCategories().get(0);
        Product p = new Product("그래픽 스웨트 셔츠", 13_000, "공용 스웨트셔츠입니다.", mantoman);
        p.addSizeQuantity("s", random.nextInt(50) + 1);
        p.addSizeQuantity("m", random.nextInt(50) + 1);
        p.addSizeQuantity("l", random.nextInt(50) + 1);

        mantoman.addProduct(p);
        p = new Product("3S 스웨트 셔츠", 52_000, "블랙 무료반품", mantoman);
        p.addSizeQuantity("s", random.nextInt(50) + 1);
        p.addSizeQuantity("m", random.nextInt(50) + 1);
        p.addSizeQuantity("l", random.nextInt(50) + 1);

        mantoman.addProduct(p);
        p = new Product("맨투맨 center", 29_000, "small 맨투맨입니다.", mantoman);
        p.addSizeQuantity("s", random.nextInt(50) + 1);
        p.addSizeQuantity("m", random.nextInt(50) + 1);
        p.addSizeQuantity("l", random.nextInt(50) + 1);

        mantoman.addProduct(p);
        products.addAll(mantoman.getProducts());

        SubCategory suitPant = ((MainCategory) mainCategories.get(1)).getSubCategories().get(0);
        p = new Product("원턱 와이드 슬랙스", 43_000, "이쁜 슬랙스입니다.", suitPant);
        p.addSizeQuantity("s", random.nextInt(50) + 1);
        p.addSizeQuantity("m", random.nextInt(50) + 1);
        p.addSizeQuantity("l", random.nextInt(50) + 1);
        suitPant.addProduct(p);

        p = new Product("세미 와이드 밴딩 슬랙스", 26_000, "블랙 슬랙스입니다.", suitPant);
        p.addSizeQuantity("s", random.nextInt(50) + 1);
        p.addSizeQuantity("m", random.nextInt(50) + 1);
        p.addSizeQuantity("l", random.nextInt(50) + 1);
        suitPant.addProduct(p);

        p = new Product("쿨링 냉장고 슬랙스", 27_000, "small 작은 슬랙스입니다.", suitPant);
        p.addSizeQuantity("s", random.nextInt(50) + 1);
        p.addSizeQuantity("m", random.nextInt(50) + 1);
        p.addSizeQuantity("l", random.nextInt(50) + 1);
        suitPant.addProduct(p);
        products.addAll(suitPant.getProducts());

        SubCategory hood = ((MainCategory) mainCategories.get(2)).getSubCategories().get(0);
        p = new Product("화이트라벨", 58_000, "체크 후드티입니다.", hood);
        p.addSizeQuantity("s", random.nextInt(50) + 1);
        p.addSizeQuantity("m", random.nextInt(50) + 1);
        p.addSizeQuantity("l", random.nextInt(50) + 1);
        hood.addProduct(p);

        p = new Product("컬리지 후드 집업", 38_500, "스타 로고 후드티입니다.", hood);
        p.addSizeQuantity("s", random.nextInt(50) + 1);
        p.addSizeQuantity("m", random.nextInt(50) + 1);
        p.addSizeQuantity("l", random.nextInt(50) + 1);
        hood.addProduct(p);

        p = new Product("오버랩 2way", 62_000, "회색 후드티입니다..", hood);
        p.addSizeQuantity("s", random.nextInt(50) + 1);
        p.addSizeQuantity("m", random.nextInt(50) + 1);
        p.addSizeQuantity("l", random.nextInt(50) + 1);
        hood.addProduct(p);
        products.addAll(hood.getProducts());
    }

    private void initAdmin() {
        Customer admin = new Customer("admin", "990505", "010-4212-5212", Role.ADMIN);
        this.customers.add(admin);
    }
}
