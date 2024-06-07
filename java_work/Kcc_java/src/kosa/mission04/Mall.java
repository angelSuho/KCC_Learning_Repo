package kosa.mission04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mall {
    private List<Customer> customers;
    private List<Order> orders;
    private List<Product> products;
    private long totalAmount;
    private List<MainCategory> mainCategories;

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

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public Customer customerLogin(String phoneNumber) throws Exception {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        throw new Exception("존재하지 않는 회원입니다.");
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void addMainCategories(List<MainCategory> mainCategories) {
        this.mainCategories.addAll(mainCategories);
    }

    public List<MainCategory> getMainCategories() {
        return mainCategories;
    }

    public void printMainCategories() {
        System.out.println("대분류 카테고리 이름 : ");
        for (MainCategory mainCategory : mainCategories) {
            System.out.println(mainCategory.getName());
            System.out.println("---------------");
        }
    }

    public MainCategory getMainCategoryByName(String name) throws Exception {
        for (MainCategory mainCategory : mainCategories) {
            if (mainCategory.getName().equals(name)){
                return mainCategory;
            }
        }
        throw new Exception("대분류 카테고리의 이름이 알맞지 않습니다.");
    }

    public List<Product> validProductName(List<String> names) throws Exception {
        List<Product> validProducts = new ArrayList<>();
        for (Product p : products) {
            if (names.contains(p.getName())) {
                validProducts.add(p);
            }
        }
        if (names.size() != validProducts.size()) {
            throw new Exception("상품 명이 올바르지 않습니다.");
        }
        return validProducts;
    }

    public SubCategory getSubCategoryByName(String name) throws Exception {
        for (MainCategory mainCategory : mainCategories) {
            List<SubCategory> subCategories = mainCategory.getSubCategories();
            for (SubCategory subCategory : subCategories) {
                if (subCategory.getName().equals(name)) {
                    return subCategory;
                }
            }
        }
        throw new Exception("대분류 카테고리의 이름이 알맞지 않습니다.");
    }

    public void printOrders() {
        System.out.println("개별 주문 목록 보기");
        for (Order order : orders) {
            order.printProducts();
            System.out.println("-------------");
        }
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
        System.out.println(categories.size());
    }

    private void initProducts() {
        List<MainCategory> mainCategories = getMainCategories();
        System.out.println(mainCategories.size());
        SubCategory mantoman = mainCategories.get(0).getSubCategories().get(0);
        mantoman.addProduct(new Product("그래픽 스웨트 셔츠", 13_000, "공용 스웨트셔츠입니다.", mantoman));
        mantoman.addProduct(new Product("3S 스웨트 셔츠", 52_000, "블랙 무료반품", mantoman));
        mantoman.addProduct(new Product("맨투맨 center", 29_000, "small 맨투맨입니다.", mantoman));
        products.addAll(mantoman.getProducts());

        SubCategory suitPant = mainCategories.get(1).getSubCategories().get(0);
        suitPant.addProduct(new Product("원턱 와이드 슬랙스", 43_000, "이쁜 슬랙스입니다.", suitPant));
        suitPant.addProduct(new Product("세미 와이드 밴딩 슬랙스", 26_000, "블랙 슬랙스입니다.", suitPant));
        suitPant.addProduct(new Product("쿨링 냉장고 슬랙스", 27_000, "small 작은 슬랙스입니다.", suitPant));
        products.addAll(suitPant.getProducts());

        SubCategory hood = mainCategories.get(2).getSubCategories().get(0);
        hood.addProduct(new Product("화이트라벨", 58_000, "체크 후드티입니다.", hood));
        hood.addProduct(new Product("컬리지 후드 집업", 38_500, "스타 로고 후드티입니다.", hood));
        hood.addProduct(new Product("오버랩 2way", 62_000, "회색 후드티입니다..", hood));
        products.addAll(hood.getProducts());
    }

    private void initAdmin() {
        Customer admin = new Customer("어드민", "111111", "111-1111-1111", Role.ADMIN);
        this.customers.add(admin);
    }
}
