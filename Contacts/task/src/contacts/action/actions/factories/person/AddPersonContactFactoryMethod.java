package contacts.action.actions.factories.person;

import contacts.contact.BaseContact;

import java.util.Scanner;

public class AddPersonContactFactoryMethod extends BasicPersonContactFactoryMethod {

    public AddPersonContactFactoryMethod(Scanner scanner) {
        super(scanner);
    }

    @Override
    public BaseContact updateContact() {
        addName();
        addSurname();
        addBirthDate();
        addGender();
        addNumber();
        return contact;
    }
}
