package contacts.action;

import contacts.Contact;
import contacts.Contacts;

import java.util.Scanner;

public abstract class ActionBase implements Action {

    protected Contacts contacts;
    protected Scanner scanner;

    public ActionBase(Contacts contacts, Scanner scanner) {
        this.contacts = contacts;
        this.scanner = scanner;
    }

    protected void alertWrongNumber(Contact contact) {
        if (!contact.hasNumber()) {
            System.out.println("Wrong number format!");
        }
    }
}
