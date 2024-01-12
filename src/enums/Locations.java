package enums;

public enum Locations {
    LAWN("Лужайка"),
    BACKROOM("Задняя комната"),
    PLACEWITHPHONE("Место с телефоном"),
    KITCHEN("Кухня"),
    NEARTHEHOUSE("Около дома"),
    KINDERGARTEN("Детский сад"),
    PORCH("Веранда"),
    HOSPITAL("Лазарет"),
    ROAD("Дорога"),
    SOFTSEMPTEMBERAIR("Мягкий сентябрьский воздух"),
    STAIRS("Ступеньки"),
    FREEEENVIRONMENT("Неопределенное пространство"),
    TRAY("Поднос");
    public final String name;
    Locations(String name) {
        this.name = name;
    }
    public String getLocName() {
        return name;
    }
}
