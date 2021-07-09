package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;

import java.util.Scanner;

public abstract class ActionWithId extends ActionBase {

    protected int id;

    public ActionWithId(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    public void setId(int id) {
        this.id = id;
    }
}
