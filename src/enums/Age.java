package enums;

public enum Age {
    BABY("младенец"),
    CHILD("ребенок"),
    ADULT("взрослый"),
    OLD("пожилой");
    private final String name;

    Age(String name) {
        this.name = name;
    }

    public String getAgeName() {
        return name;
    }
}
