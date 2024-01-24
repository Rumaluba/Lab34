package enums;

public enum Drinkables {
    COFFEE("кофе");
    private final String name;

    Drinkables(String name) {
        this.name = name;
    }

    public String getNameDrinkables() {
        return name;
    }
}

