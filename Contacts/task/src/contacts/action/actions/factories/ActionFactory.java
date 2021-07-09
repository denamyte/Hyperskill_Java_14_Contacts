package contacts.action.actions.factories;

import contacts.Contacts;
import contacts.action.Action;
import contacts.action.actions.*;

import java.util.Scanner;

public class ActionFactory {

    private final Contacts contacts;
    private final Scanner scanner;

    private final AddAction addAction;
    private final ListAction listAction;
    private final CountAction countAction;
    private final DeleteAction deleteAction;
    private final EditAction editAction;
    private final RecordAction recordAction;
    private final SearchAction searchAction;

    public ActionFactory(Contacts contacts, Scanner scanner) {
        this.contacts = contacts;
        this.scanner = scanner;

        addAction = new AddAction(contacts, scanner);
        countAction = new CountAction(contacts);
        editAction = new EditAction(contacts, scanner);
        deleteAction = new DeleteAction(contacts);

        recordAction = new RecordAction(contacts, scanner);
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

    public EditAction getEditAction() {
        return editAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public RecordAction getRecordAction() {
        return recordAction;
    }
}
