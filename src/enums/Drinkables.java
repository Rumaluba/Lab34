package enums;

public enum Drinkables {
    JUICE("сок"),
    COFFEE("кофе"),
    WATER("вода"),
    ALCOHOL("алкоголь");
    private final String name;

    Drinkables(String name) {
        this.name = name;
    }

    public String getNameDrinkables() {
        return name;
    }
}

