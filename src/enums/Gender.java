package enums;

public enum Gender {
    MALE("мужского пола"),
    FEMALE("женского пола"),
    NEUTRAL("среднего рода");
    public final String name;
    Gender (String name) {
        this.name = name;
    }
    public String getGenderName() {
        return name;
    }
}
