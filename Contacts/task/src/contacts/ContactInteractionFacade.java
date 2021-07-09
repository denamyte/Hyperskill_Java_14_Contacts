package contacts;

import contacts.action.Action;
import contacts.action.ActionName;
import contacts.action.ActionInvoker;
import contacts.action.actions.factories.ActionFactory;

import java.util.Map;
import java.util.Scanner;

public class ContactInteractionFacade {

    private static ActionName getActionName(Scanner scanner) {
        System.out.print("[menu] Enter action (add, list, search, count, exit): ");
        return ActionName.fromString(scanner.nextLine());
    }

    public static void stage4(String fileName) {
        try (Scanner scanner = new Scanner(System.in)) {
            Contacts contacts = Contacts.createOrLoadFromFile(fileName);

            ActionFactory acFac = new ActionFactory(contacts, scanner);

            Map<ActionName, Action> actionMap = Map.of(
                    ActionName.ADD, acFac.getAddAction(),
                    ActionName.LIST, acFac.getListAction(),
                    ActionName.SEARCH, acFac.getSearchAction(),
                    ActionName.COUNT, acFac.getCountAction(),
                    ActionName.EXIT, () -> {}
            );

            ActionName actionName = getActionName(scanner);
            ActionInvoker invoker = new ActionInvoker(actionMap.get(actionName));

            while (ActionName.EXIT != actionName) {
                invoker.executeAction();

                actionName = getActionName(scanner);
                invoker.setAction(actionMap.get(actionName));
            }
        } catch (Exception ignored) {
        }
    }

}
