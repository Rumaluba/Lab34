package entity;

import enums.*;
import exception.*;
import interfaces.Drink;

import java.util.ArrayList;
import java.util.Objects;

import static enums.Gender.*;

public class Human extends Entity implements Drink {
    static boolean isPhoneDialogActive;
    static boolean isOfflineDialogActive;
    static ArrayList<Entity> humans;

    static {
        isPhoneDialogActive = false;
        isOfflineDialogActive = false;
        humans = new ArrayList<>();
    }

    private Age age;
    private final Gender gender;

    public Human(String name, Locations location, Age age, Gender gender) throws RuntimeException {
        super(name, location);
        this.gender = gender;
        this.age = age;
        if (humans.contains(this)) throw new RuntimeException("Двух одинаковых людей не бывает");
        humans.add(this);
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

    public void hug(Human human) throws LocationException {
        try {
            if (this.getLocation() != human.getLocation())
                throw new LocationException("Объекты, находящиеся в разных локациях не могут взаимодействовать!");
            else {
                if (!objects.contains(human)) {
                    System.out.printf("%s и %s обнялись\n", this.getName(), human.getName());
                    objects.add(human);
                    human.objects.add(this);
                }
            }
        } catch (LocationException lex) {
            System.out.println(lex.getMessage());
        }
    }

    public void breakHug(Human human) {
        if (objects.contains(human)) {
            System.out.printf("%s и %s разорвали объятия\n", this.getName(), human.getName());
            objects.remove(human);
            human.objects.remove(this);
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
        return String.format("Был создан человек по имени %s, %s, %s, в локации %s", this.getName(), age, gender.getGenderName(), this.getLocation().getLocName());
    }
}

