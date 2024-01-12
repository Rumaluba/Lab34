package enums;

public enum Locations {
    LAWN("Лужайка"),
    BACKROOM("Задняя комната"),
    KITCHEN("Кухня"),
    NEARTHEHOUSE("Около дома"),
    HOSPITAL("Лазарет"),
    ROAD("Дорога"),
    SOFTSEMPTEMBERAIR("Мягкий сентябрьский воздух"),

    FREEEENVIRONMENT("Неопределенное пространство");
    public final String name;
    Locations(String name) {
        this.name = name;
    }
    public String getLocName() {
        return name;
    }
}
