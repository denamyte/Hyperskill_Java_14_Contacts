package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;

import java.util.Scanner;

public class RemoveAction extends ActionBase {

    public RemoveAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    @Override
    public void execute() {
        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        System.out.println(contacts);
        System.out.print("Select a record: ");
        int index = -1 + Integer.parseInt(scanner.nextLine());
        contacts.remove(index);
        System.out.println("The record removed!");
    }
}
