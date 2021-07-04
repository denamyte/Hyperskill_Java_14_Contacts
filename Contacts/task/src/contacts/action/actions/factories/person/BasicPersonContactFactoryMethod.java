package contacts.action.actions.factories.person;

import contacts.action.actions.factories.BasicContactFactoryMethod;
import contacts.contact.PersonContact;

import java.util.Scanner;

public abstract class BasicPersonContactFactoryMethod extends BasicContactFactoryMethod {

    public BasicPersonContactFactoryMethod(Scanner scanner) {
        super(scanner);
    }

    private PersonContact cast() {
        return (PersonContact) contact;
    }

    @Override
    public void addName() {
        System.out.print("Enter the name: ");
        contact.setName(scanner.nextLine());
    }

    protected void addSurname() {
        System.out.print("Enter the surname: ");
        cast().setSurname(scanner.nextLine());
    }

    protected void addBirthDate() {
        System.out.print("Enter the birth date: ");
        cast().setBirthDate(scanner.nextLine());
        if (cast().getBirthDate() == null) {
            System.out.println("Bad birth date!");
        }
    }

    protected void addGender() {
        System.out.print("Enter the gender (M, F): ");
        cast().setGender(PersonContact.Gender.fromStr(scanner.nextLine()));
        if (cast().getGender() == null) {
            System.out.println("Bad gender!");
        }
    }

}
