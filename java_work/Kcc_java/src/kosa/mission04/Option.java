package kosa.mission04;

public enum Option {

    CARD("카드"),
    CASH("현금"),
    ACCOUNT("계좌")
    ;

    private String type;

    Option() {}
    Option(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public static Option getOption(String type) {
        for (Option option : values()) {
            if (option.getType().equals(type)) {
                return option;
            }
        }
        return null;
    }
}
