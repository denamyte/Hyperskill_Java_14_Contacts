package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;

import java.util.Scanner;

public class InfoAction extends ActionBase {

    public InfoAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    @Override
    public void execute() {
        if (contacts.size() > 0) {
            System.out.println(contacts);
            System.out.print("Select a record: ");
            int index = -1 + Integer.parseInt(scanner.nextLine());
            System.out.println(contacts.getContactByIndex(index));
        } else {
            System.out.println();
        }
    }
}
