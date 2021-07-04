package contacts.action.actions.factories.org;

import contacts.contact.BaseContact;

import java.util.Scanner;

public class AddOrgContactFactoryMethod extends BasicOrgContactFactoryMethod {

    public AddOrgContactFactoryMethod(Scanner scanner) {
        super(scanner);
    }

    @Override
    public BaseContact updateContact() {
        addName();
        addAddress();
        addNumber();
        return contact;
    }
}
