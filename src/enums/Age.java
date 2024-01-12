package enums;

public enum Age {
    BABY ("младенец"),
    CHILD ("ребенок"),
    TEEN("подросток"),
    ADULT("взрослый"),
    OLD("пожилой");
    public final String name;
    Age(String name) {
        this.name = name;
    }
    public String getAgeName() {
        return name;
    }
}
