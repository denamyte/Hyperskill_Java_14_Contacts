package contacts.action.actions;

import contacts.Contacts;

import java.util.Arrays;
import java.util.Scanner;

public class RecordAction extends ActionWithId {

    private EditAction editAction;
    private DeleteAction deleteAction;

    public RecordAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    public void setEditAction(EditAction editAction) {
        this.editAction = editAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    @Override
    public void execute() {
        Command cmd = getCommand();
        while (Command.MENU != cmd) {

            // TODO: 7/9/21 Implement!

            cmd = getCommand();
        }
        System.out.println();
    }

    private Command getCommand() {
        System.out.print("[record] Enter action (edit, delete, menu): ");
        return Command.fromString(scanner.nextLine().toUpperCase());
    }

    enum Command {
        EDIT, DELETE, MENU;

        static Command fromString(String name) {
            return Arrays.stream(values()).filter(cmd -> cmd.name().equals(name)).findFirst().orElse(null);
        }
    }
}
