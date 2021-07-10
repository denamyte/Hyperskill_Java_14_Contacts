package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;

import java.util.Scanner;

public class ListAction extends ActionBase {

    private RecordAction recordAction;

    public ListAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    public void setRecordAction(RecordAction recordAction) {
        this.recordAction = recordAction;
    }

    @Override
    public void execute() {
        if (contacts.size() == 0) {
            return;
        }
        System.out.println(contacts);
        System.out.println();
        listMenu();
    }

    private void listMenu() {
        System.out.print("[list] Enter action ([number], back): ");
        String cmd = scanner.nextLine();
        if ("back".equals(cmd)) {
            System.out.println();
            return;
        }
        int i = -1 + Integer.parseInt(cmd);
        System.out.println(contacts.getContactByIndex(i));
        recordAction.setId(i);
        recordAction.execute();
    }
}
