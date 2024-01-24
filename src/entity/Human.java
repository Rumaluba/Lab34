package entity;

import enums.*;
import exception.*;
import interfaces.Drink;
import locations.World;

import java.util.ArrayList;
import java.util.Objects;

import static enums.Gender.*;

public class Human extends Unfixed implements Drink {
    static boolean isPhoneDialogActive;
    static boolean isOfflineDialogActive;
    static private ArrayList<Human> humans;

    static {
        isPhoneDialogActive = false;
        isOfflineDialogActive = false;
        humans = new ArrayList<>();
    }
    private Age age;
    private final Gender gender;

    public Human(Age age, Gender gender, World location, String name) throws RuntimeException {
        super(name, location);
        this.gender = gender;
        this.age = age;
        if (humans.contains(this)) throw new RuntimeException("Двух одинаковых людей не бывает");
        setHumans(this);
    }
    public Gender getGender() {
        return gender;
    }

    public void idea(String phrase) {
        System.out.printf(this.getGender() == MALE ? "%s " + "подумал: %s \n" : "%s " + "подумала: %s \n", this.getName(), phrase);
    }

    public void talkPhone(String phrase) throws DialogException {
        if (isPhoneDialogActive) {
            throw new DialogException("Нельза начать новый диалог, пока старый не завершен!");
        } else
            System.out.printf(this.gender == MALE ? "%s " + "сказал по телефону: %s \n" : "%s " + "сказала по телефону: %s \n", this.getName(), phrase);
        isPhoneDialogActive = true;
    }

    public void continuePhoneDialog(String phrase) throws DialogException {
        if (!isPhoneDialogActive) {
            throw new DialogException("Диалог только начался, а не продолжился!");
        } else {
            System.out.printf(this.gender == MALE ? "%s " + "ответил по телефону: %s \n" : "%s " + "ответила по телефону: %s \n", this.getName(), phrase);
        }
    }

    public void endPhoneDialog() throws DialogException {
        if (!isPhoneDialogActive) {
            throw new DialogException("Нельзя закончить неначавшийся диалог!");
        } else {
            isPhoneDialogActive = false;
        }
    }

    public void talk(String phrase) throws DialogException {
        if (isOfflineDialogActive) {
            throw new DialogException("Нельза начать новый диалог, пока старый не завершен!");
        } else
            System.out.printf(this.gender == MALE ? "%s " + "сказал: %s \n" : "%s " + "сказала: %s \n", this.getName(), phrase);
        isOfflineDialogActive = true;
    }

    public void continueDialog(String phrase) throws DialogException {
        if (!isOfflineDialogActive) {
            throw new DialogException("Диалог только начался, а не продолжился!");
        } else {
            System.out.printf(this.gender == MALE ? "%s " + "ответил: %s \n" : "%s " + "ответила: %s \n", this.getName(), phrase);
        }
    }

    public void endDialog() throws DialogException {
        if (!isOfflineDialogActive) {
            throw new DialogException("Нельзя закончить неначавшийся диалог!");
        } else {
            isOfflineDialogActive = false;
        }
    }

    public void hug(Human human) {
        try {
            if (this.getLocation() != human.getLocation())
                throw new LocationException("Объекты, находящиеся в разных локациях не могут взаимодействовать!");
            else {
                if (!getobj().contains(human)) {
                    System.out.printf("%s и %s обнялись\n", this.getName(), human.getName());
                    getobj().add(human);
                    human.getobj().add(this);
                }
            }
        } catch (LocationException lex) {
            System.out.println(lex.getMessage());
        }
    }

    public void breakHug(Human human) {
        if (getobj().contains(human)) {
            System.out.printf("%s и %s разорвали объятия\n", this.getName(), human.getName());
            getobj().remove(human);
            human.getobj().remove(this);
        }
    }

    public void swear(String str) {
        try {
            if (age != Age.ADULT && age != (Age.OLD))
                throw new AgeException("Детям и подросткам ругаться нельзя!");
            else
                System.out.printf(this.getGender() == MALE ? "%s выругался: " + reform(str) + "\n" : "%s выругалась: " + reform(str) + "\n", this.getName());
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
    }

    public String reform(String str) {
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if ((x != '!') && (x != ' ') && (x != ',') && (x != '.')) {
                str = str.substring(0, i) + '*' + str.substring(i + 1);
            }
        }
        return str;
    }

    public void setLocation(World location) {
        try {
            if (checkTransport()) {
                throw new LocationException("Нельзя поменять локацию не выйдя из транспорта!");
            } else {
                setMobility(true);
                this.location = location;
                location.setOperands(this);
                System.out.printf("объект %s сменил локацию на %s\n", getName(), location.getLocName());
            }
            for (int i = 0; i < getobj().size(); i++)
                if (getobj().get(i).location != location) {
                    getobj().get(i).setLocation(location);
                }
            setMobility(false);
        } catch (LocationException l) {
            System.out.println(l.getMessage());
        }
    }
    public void take(Entity entity) {
        System.out.printf("%s добавил себе в инвентарь %s\n", getName(), entity.getName());
    }
    public void setHumans(Human human) {
        humans.add(human);
    }
    @Override
            public void drink(Drinkables drinkable, Volume volume) {
        System.out.printf(this.gender == MALE ? "%s выпил %s %s\n" : "%s выпила %s %s \n", this.getName(), volume.getNameVolume(), drinkable.getNameDrinkables());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getGender());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Human that = (Human) object;
        return Objects.equals(this.getName(), that.getName()) && gender == that.getGender();
    }

    @Override
    public String toString() {
        return String.format("человек по имени %s, %s, %s, в локации %s", this.getName(),age.getAgeName(), gender.getGenderName(), this.getLocation().getLocName());
    }
}

