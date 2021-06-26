package contacts;

import contacts.action.Action;
import contacts.action.ActionEnum;
import contacts.action.ActionInvoker;
import contacts.action.actions.*;

import java.util.Map;
import java.util.Scanner;

public class ContactInteractionFacade {

    private static ActionEnum getAction(Scanner scanner) {
        System.out.print("Enter action (add, remove, edit, count, info, exit): ");
        return ActionEnum.fromString(scanner.nextLine());
    }

    public static void stage3() {
        try (Scanner scanner = new Scanner(System.in)) {
            Contacts contacts = new Contacts();

            Map<ActionEnum, Action> actionMap = Map.of(
                    ActionEnum.ADD, new AddAction(contacts, scanner),
                    ActionEnum.REMOVE, new RemoveAction(contacts, scanner),
                    ActionEnum.EDIT, new EditAction(contacts, scanner),
                    ActionEnum.COUNT, new CountAction(contacts),
                    ActionEnum.INFO, new ListAction(contacts),
                    ActionEnum.EXIT, () -> {}
            );

            ActionEnum actionEnum = getAction(scanner);
            ActionInvoker invoker = new ActionInvoker(actionMap.get(actionEnum));

            while (ActionEnum.EXIT != actionEnum) {
                invoker.executeAction();

                actionEnum = getAction(scanner);
                invoker.setAction(actionMap.get(actionEnum));
            }
        }
    }
}
