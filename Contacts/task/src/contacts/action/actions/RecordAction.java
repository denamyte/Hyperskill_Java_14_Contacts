package contacts.action.actions;

import contacts.Contacts;

import java.util.*;

public class RecordAction extends ActionWithId {

    private static final ActionWithId menuAction = new ActionWithId(null, null) {
        @Override
        public void execute() { }
    };

    private Map<Command, ActionWithId> actionMap = new HashMap<>();

    public RecordAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
        actionMap.put(Command.MENU, menuAction);
    }

    public void setEditAction(EditAction editAction) {
        actionMap.put(Command.EDIT, editAction);
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        actionMap.put(Command.DELETE, deleteAction);
    }

    private Command getCommand() {
        System.out.print("[record] Enter action (edit, delete, menu): ");
        return Command.fromString(scanner.nextLine().toUpperCase());
    }

    @Override
    public void execute() {
        Command cmd;
        do {
            cmd = getCommand();
            ActionWithId action = actionMap.get(cmd);
            action.setId(id);
            action.execute();

        } while (cmd == Command.EDIT);
        System.out.println();
    }

    enum Command {
        EDIT, DELETE, MENU;

        static Command fromString(String name) {
            return Arrays.stream(values()).filter(cmd -> cmd.name().equals(name)).findFirst().orElse(null);
        }
    }
}
