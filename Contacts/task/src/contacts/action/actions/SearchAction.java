package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;

import java.util.Scanner;

public class SearchAction extends ActionBase {

    private RecordAction recordAction;

    public SearchAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    public void setRecordAction(RecordAction recordAction) {
        this.recordAction = recordAction;
    }

    @Override
    public void execute() {

        // TODO: 7/9/21 IMPLEMENT!

    }
}
