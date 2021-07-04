package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;
import contacts.action.actions.factories.BasicContactFactoryMethod;
import contacts.action.actions.factories.org.UpdateOrgContactFactoryMethod;
import contacts.action.actions.factories.person.UpdatePersonContactFactoryMethod;
import contacts.contact.BaseContact;
import contacts.contact.OrganizationContact;
import contacts.contact.PersonContact;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EditAction extends ActionBase {

    private final Map<Class<? extends BaseContact>, BasicContactFactoryMethod> factoryMethodMap = new HashMap<>(2);

    public EditAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
        factoryMethodMap.put(OrganizationContact.class, new UpdateOrgContactFactoryMethod(scanner));
        factoryMethodMap.put(PersonContact.class, new UpdatePersonContactFactoryMethod(scanner));
    }

    @Override
    public void execute() {
        System.out.println(contacts);  // Print a short list of contacts

        if (contacts.size() == 0) {
            System.out.println("No records to edit\n");
            return;
        }

        System.out.print("Select a record: ");
        String rawStr = scanner.nextLine();

        int index = -1 + Integer.parseInt(rawStr);
        BaseContact contact = contacts.getContactByIndex(index);

        BasicContactFactoryMethod factoryMethod = factoryMethodMap.get(contact.getClass());
        factoryMethod.setContact(contact);
        factoryMethod.updateContact();

        contact.updateTimeLastEdit();
        System.out.println("The record updated!\n");
    }
}
