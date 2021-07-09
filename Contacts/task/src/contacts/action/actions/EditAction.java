package contacts.action.actions;

import contacts.Contacts;
import contacts.action.actions.factories.BasicContactFactoryMethod;
import contacts.action.actions.factories.org.UpdateOrgContactFactoryMethod;
import contacts.action.actions.factories.person.UpdatePersonContactFactoryMethod;
import contacts.contact.BaseContact;
import contacts.contact.OrganizationContact;
import contacts.contact.PersonContact;

import java.util.Map;
import java.util.Scanner;

public class EditAction extends ActionWithId {

    private Map<Class<? extends BaseContact>, BasicContactFactoryMethod> factoryMethodMap;

    public EditAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
        factoryMethodMap = Map.of(
                OrganizationContact.class, new UpdateOrgContactFactoryMethod(scanner),
                PersonContact.class, new UpdatePersonContactFactoryMethod(scanner)
        );
    }

    @Override
    public void execute() {
        BaseContact contact = contacts.getContactByIndex(id);

        BasicContactFactoryMethod factoryMethod = factoryMethodMap.get(contact.getClass());
        factoryMethod.setContact(contact);
        factoryMethod.updateContact();

        contact.updateSearchField();
        contact.updateTimeLastEdit();
        contacts.saveToFile();
        System.out.println(contact);
    }
}
