package contacts;

@Deprecated
public class Contact {

    private String name;
    private String surname;
    private String phone = "";

    private Contact() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = checkPhone(phone) ? phone : "";
    }

    public boolean hasNumber() {
        return !phone.isEmpty();
    }

    private static boolean checkPhone(String phone) {
        return phone.matches("^\\+?(((\\(\\w+\\))([- ]\\w{2,})?)|((\\w+)([- ]\\(\\w{2,}\\))?))([- ]\\w{2,})*$");
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", name, surname, hasNumber() ? phone : "[no number]");
    }

    public static class Builder {
        private String name;
        private String surname;
        private String phone = "";

        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Contact build() {
            Contact contact = new Contact();
            contact.setName(name);
            contact.setSurname(surname);
            contact.setPhone(phone);
            return contact;
        }
    }
}
