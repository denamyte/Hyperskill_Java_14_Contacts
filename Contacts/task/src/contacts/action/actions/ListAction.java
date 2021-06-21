package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;

public class ListAction extends ActionBase {

    public ListAction(Contacts contacts) {
        super(contacts, null);
    }

    @Override
    public void execute() {
        System.out.println(contacts);
    }
}
