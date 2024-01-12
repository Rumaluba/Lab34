package humans;

import entity.*;
import exception.*;
import enums.Age;
import enums.Gender;
import enums.Locations;
import interfaces.Look;

import java.util.Objects;

import static enums.Gender.*;


public class Human extends Entity implements Look {
    static int Count;
    static int Count1;

    static {
        Count = 0;
        Count1 = 0;
    }

    public Human(String name, Locations location, Age age, Gender gender) throws GenderException {
        super(name, location, age, gender);
        if (gender == Gender.NEUTRAL) throw new GenderException("Человек не может быть среднего пола");
    }

    public void idea(String phrase) {
        System.out.printf(this.getGender() == MALE ? "%s " + "подумал: %s \n" : "%s " + "подумала: %s \n", this.getName(), phrase);
    }

    public void talkPhone(String phrase) throws DialogException {
        if (Count != 0) {
            throw new DialogException("Нельза начать новый диалог, пока старый не завершен!");
        } else
            System.out.printf(this.getGender() == MALE ? "%s " + "сказал по телефону: %s \n" : "%s " + "сказала по телефону: %s \n", this.getName(), phrase);
        Count++;
    }

    public void continuePhoneDialog(String phrase) throws DialogException {
        if (Count == 0) {
            throw new DialogException("Диалог только начался, а не продолжился!");
        } else {
            System.out.printf(this.getGender() == MALE ? "%s " + "ответил по телефону: %s \n" : "%s " + "ответила по телефону: %s \n", this.getName(), phrase);
            Count++;
        }
    }

    public void endPhoneDialog() throws DialogException {
        if (Count == 0) {
            throw new DialogException("Нельзя закончить неначавшийся диалог!");
        } else {
            Count = 0;
        }
    }

    public void talk(String phrase) throws DialogException {
        if (Count1 != 0) {
            throw new DialogException("Нельза начать новый диалог, пока старый не завершен!");
        } else
            System.out.printf(this.getGender() == MALE ? "%s " + "сказал: %s \n" : "%s " + "сказала: %s \n", this.getName(), phrase);
        Count1++;
    }

    public void continueDialog(String phrase) throws DialogException {
        if (Count1 == 0) {
            throw new DialogException("Диалог только начался, а не продолжился!");
        } else {
            System.out.printf(this.getGender() == MALE ? "%s " + "ответил: %s \n" : "%s " + "ответила: %s \n", this.getName(), phrase);
            Count++;
        }
    }

    public void endDialog() throws DialogException {
        if (Count1 == 0) {
            throw new DialogException("Нельзя закончить неначавшийся диалог!");
        } else {
            Count1 = 0;
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
        } catch (LocationException l) {
            System.out.println(l.getMessage());
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
    public void look() {
        if (this.getGender() == MALE) {
            System.out.printf("%s смотрел \n", this.getName());
        } else {
            System.out.printf("%s смотрела\n", this.getName());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getGender(), this.getLocation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human that = (Human) o;
        return Objects.equals(this.getName(), that.getName()) && Objects.equals(this.getGender(), that.getGender()) && Objects.equals(this.getLocation(), that.getLocation());
    }

    @Override
    public String toString() {
        return String.format("Был создан человек по имени %s, %s, %s, в локации %s", this.getName(), age.getAgeName(), this.getGender().getGenderName(), this.getLocation().getLocName());
    }
}

