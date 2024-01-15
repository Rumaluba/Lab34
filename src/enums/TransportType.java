package enums;

public enum TransportType {
    BUS("автобус"),
    CAR("машина"),
    TRUCK("грузовик"),
    CART("повозка"),
    WHEELBARROW("тачка");
    private final String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getNameType() {
        return name;
    }
}
