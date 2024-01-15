package enums;

public enum Gender {
    MALE("мужского пола"),
    FEMALE("женского пола");
    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getGenderName() {
        return name;
    }
}
