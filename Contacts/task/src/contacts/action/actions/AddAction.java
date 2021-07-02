package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;
import contacts.action.actions.factories.AddOrgContactFactoryMethod;
import contacts.action.actions.factories.AddPersonContactFactoryMethod;
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

    private final Map<Type, BasicContactFactoryMethod> factoryMethodMap;

    public AddAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
        factoryMethodMap = Map.of(
                Type.PERSON, new AddPersonContactFactoryMethod(scanner),
                Type.ORGANIZATION, new AddOrgContactFactoryMethod(scanner)
        );
    }

    @Override
    public void execute() {
        System.out.print("Enter the type (person, organization): ");
        Type type = Type.valueOf(scanner.nextLine());

        BasicContactFactoryMethod factoryMethod = factoryMethodMap.get(type);
        factoryMethod.setContact(CONTACT_SUPPLIER_MAP.get(type).get());

        BaseContact contact = factoryMethod.updateContact();
        contact.iniTimeCreated();
        contacts.saveContact(contact);
        System.out.println("The record added.\n");
    }

    enum Type {
        PERSON, ORGANIZATION
    }
}
