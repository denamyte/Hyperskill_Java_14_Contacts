package contacts.action.actions.factories;

import contacts.contact.BaseContact;

import java.util.Scanner;

public abstract class BasicContactFactoryMethod {

    protected Scanner scanner;
    protected BaseContact contact;

    public BasicContactFactoryMethod(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract BaseContact updateContact();

    public abstract void addName();

    public void addNumber() {
        System.out.print("Enter the number: ");
        contact.setPhone(scanner.nextLine());
        if (contact.getPhone() == null) {
            System.out.println("Bad phone!");
        }
    }

    public void setContact(BaseContact contact) {
        this.contact = contact;
    }
}
