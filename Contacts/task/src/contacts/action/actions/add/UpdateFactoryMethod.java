package contacts.action.actions.add;

import contacts.contact.BaseContact;

import java.util.Scanner;

public abstract class UpdateFactoryMethod {

    protected Scanner scanner;
    protected BaseContact contact;

    public UpdateFactoryMethod(Scanner scanner, BaseContact contact) {
        this.scanner = scanner;
        this.contact = contact;
    }

    public abstract void addName();

    public void updatePhone() {
        System.out.print("Enter the number: ");
        contact.setPhone(scanner.nextLine());
        if (contact.getPhone() == null) {
            System.out.println("Bad phone!");
        }
    }
}
