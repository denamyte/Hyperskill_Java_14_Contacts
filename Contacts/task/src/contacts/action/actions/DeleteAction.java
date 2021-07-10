package contacts.action.actions;

import contacts.Contacts;

public class DeleteAction extends ActionWithId {

    public DeleteAction(Contacts contacts) {
        super(contacts, null);
    }

    @Override
    public void execute() {
        contacts.remove(id);
        System.out.println("Record deleted.");
        contacts.saveToFile();
    }
}
