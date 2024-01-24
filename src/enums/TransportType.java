package enums;

public enum TransportType {
    BUS("автобус");
    private final String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getNameType() {
        return name;
    }
}
