package sample.enums;

public enum  TickOrNoli {

    Tik("X"),
    Noli("0");

    private String value;

    TickOrNoli(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
