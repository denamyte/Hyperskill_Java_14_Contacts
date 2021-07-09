package contacts.contact;

import java.time.LocalDate;

public class PersonContact extends BaseContact {

    private static final long serialVersionUID = 7557756253989621039L;

    private String surname;
    private LocalDate birthDate;
    private Gender gender;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        try {
            this.birthDate = LocalDate.parse(birthDate);
        } catch (Exception e) {
            this.birthDate = null;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String getListTitle() {
        return String.format("%s %s", getName(), getSurname());
    }

    @Override
    public void updateSearchField() {
        searchField = String.join("|||", name, phone, surname);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Surname: " + surname + "\n"
                + "Birth date: " + valueOrNoData(birthDate)  + "\n"
                + "Gender: " + valueOrNoData(gender) + "\n"
                + super.toString();
    }

    public enum Gender {
        M, F;

        public static Gender fromStr(String s) {
            try {
                return valueOf(s);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }
}
