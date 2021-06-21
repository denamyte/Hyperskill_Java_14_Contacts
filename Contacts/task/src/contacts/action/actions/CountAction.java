package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;

public class CountAction extends ActionBase {

    public CountAction(Contacts contacts) {
        super(contacts, null);
    }

    @Override
    public void execute() {
        System.out.printf("The Phone Book has %d records.\n", contacts.size());
    }
}
