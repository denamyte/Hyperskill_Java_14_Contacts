package contacts.action.actions.factories.org;

import contacts.action.actions.factories.BasicContactFactoryMethod;
import contacts.contact.OrganizationContact;

import java.util.Scanner;

public abstract class BasicOrgContactFactoryMethod extends BasicContactFactoryMethod {

    public BasicOrgContactFactoryMethod(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void addName() {
        System.out.print("Enter the organization name: ");
        contact.setName(scanner.nextLine());
    }

    protected void addAddress() {
        System.out.print("Enter the address: ");
        ((OrganizationContact) contact).setAddress(scanner.nextLine());
    }
}
