package contacts.action.actions.factories;

import contacts.Contacts;
import contacts.action.Action;
import contacts.action.actions.*;
import contacts.action.actions.factories.org.AddOrgContactFactoryMethod;
import contacts.action.actions.factories.org.UpdateOrgContactFactoryMethod;
import contacts.action.actions.factories.person.AddPersonContactFactoryMethod;
import contacts.action.actions.factories.person.UpdatePersonContactFactoryMethod;
import contacts.contact.OrganizationContact;
import contacts.contact.PersonContact;

import java.util.Map;
import java.util.Scanner;

public class ActionFactory {

    private final AddAction addAction;
    private final ListAction listAction;
    private final CountAction countAction;
    private final SearchAction searchAction;

    public ActionFactory(Contacts contacts, Scanner scanner) {

        addAction = new AddAction(contacts, scanner);
        addAction.setAddFactoryMethodMap(Map.of(
                AddAction.Type.PERSON, new AddPersonContactFactoryMethod(scanner),
                AddAction.Type.ORGANIZATION, new AddOrgContactFactoryMethod(scanner)
        ));

        countAction = new CountAction(contacts);

        EditAction editAction = new EditAction(contacts, scanner);
        editAction.setUpdateFactoryMethodMap(Map.of(
                OrganizationContact.class, new UpdateOrgContactFactoryMethod(scanner),
                PersonContact.class, new UpdatePersonContactFactoryMethod(scanner)
        ));

        DeleteAction deleteAction = new DeleteAction(contacts);

        RecordAction recordAction = new RecordAction(contacts, scanner);
        recordAction.setEditAction(editAction);
        recordAction.setDeleteAction(deleteAction);

        listAction = new ListAction(contacts, scanner);
        listAction.setRecordAction(recordAction);

        searchAction = new SearchAction(contacts, scanner);
        searchAction.setRecordAction(recordAction);
    }

    public Action getAddAction() {
        return addAction;
    }

    public Action getListAction() {
        return listAction;
    }

    public Action getSearchAction() {
        return searchAction;
    }

    public Action getCountAction() {
        return countAction;
    }
}
