package contacts.action.actions;

import contacts.Contacts;
import contacts.action.actions.factories.BasicContactFactoryMethod;
import contacts.contact.BaseContact;

import java.util.Map;
import java.util.Scanner;

public class EditAction extends ActionWithId {

    private Map<Class<? extends BaseContact>, BasicContactFactoryMethod> updateFactoryMethodMap;

    public EditAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    public void setUpdateFactoryMethodMap(Map<Class<? extends BaseContact>,
            BasicContactFactoryMethod> updateFactoryMethodMap) {
        this.updateFactoryMethodMap = updateFactoryMethodMap;
    }

    @Override
    public void execute() {
        BaseContact contact = contacts.getContactByIndex(id);

        BasicContactFactoryMethod factoryMethod = updateFactoryMethodMap.get(contact.getClass());
        factoryMethod.setContact(contact);
        factoryMethod.updateContact();

        contact.updateSearchField();
        contact.updateTimeLastEdit();
        contacts.saveToFile();
        System.out.println("Saved");
        System.out.println(contact);
    }
}
