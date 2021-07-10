package contacts.action.actions;

import contacts.Contacts;
import contacts.action.ActionBase;

import java.util.Scanner;
import java.util.stream.IntStream;

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
        do {
            int[] indices = doSearch();
            System.out.print("[search] Enter action ([number], back, again): ");
            String rawStr = scanner.nextLine();
            if ("again".equals(rawStr)) {
                continue;
            }
            if (!"back".equals(rawStr)) {
                int index = indices[-1 + Integer.parseInt(rawStr)];
                System.out.println(contacts.getContactByIndex(index));
                recordAction.setId(index);
                recordAction.execute();
            } else {
                System.out.println();
            }
            break;

        } while (true);
    }

    private int[] doSearch() {
        System.out.print("Enter search query: ");
        int[] resultIds = contacts.search(scanner.nextLine());
        // Print search results
        System.out.println(resultIds.length == 0
                                   ? "No records found"
                                   : String.format("Found %d results:", resultIds.length));

        IntStream.range(0, resultIds.length)
                .mapToObj(i -> String.format("%d. %s", i + 1, contacts.getContactByIndex(resultIds[i]).getListTitle()))
                .forEach(System.out::println);
        System.out.println();

        return resultIds;
    }
}
