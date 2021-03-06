package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;
import contacts.action.actions.factories.BasicContactFactoryMethod;
import contacts.contact.BaseContact;
import contacts.contact.OrganizationContact;
import contacts.contact.PersonContact;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class AddAction extends ActionBase {

    private static final Map<Type, Supplier<BaseContact>> CONTACT_SUPPLIER_MAP = Map.of(
            Type.PERSON, PersonContact::new,
            Type.ORGANIZATION, OrganizationContact::new
    );

    private Map<Type, BasicContactFactoryMethod> addFactoryMethodMap;

    public AddAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    public void setAddFactoryMethodMap(Map<Type, BasicContactFactoryMethod> addFactoryMethodMap) {
        this.addFactoryMethodMap = addFactoryMethodMap;
    }

    @Override
    public void execute() {
        System.out.print("Enter the type (person, organization): ");
        Type type = Type.valueOf(scanner.nextLine().toUpperCase());

        BasicContactFactoryMethod factoryMethod = addFactoryMethodMap.get(type);
        factoryMethod.setContact(CONTACT_SUPPLIER_MAP.get(type).get());

        BaseContact contact = factoryMethod.updateContact();
        contact.iniTimeCreated();
        contact.updateSearchField();

        contacts.saveContact(contact);
        contacts.saveToFile();
        System.out.println("The record added.\n");
    }

    public enum Type {
        PERSON, ORGANIZATION
    }
}
