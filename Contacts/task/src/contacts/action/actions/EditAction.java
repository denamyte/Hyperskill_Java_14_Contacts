package contacts.action.actions;

import contacts.Contact;
import contacts.Contacts;
import contacts.action.ActionBase;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class EditAction extends ActionBase {

    private static final Map<String, BiConsumer<Contact, String>> CONSUMER_MAP = new LinkedHashMap<>() {{
        put("name", Contact::setName);
        put("surname", Contact::setSurname);
        put("number", Contact::setPhone);
    }};

    public EditAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    @Override
    public void execute() {
        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }
        System.out.println(contacts);
        System.out.print("Select a record: ");
        int index = -1 + Integer.parseInt(scanner.nextLine());
        Contact contact = contacts.getContactByIndex(index);

        System.out.print("Select a field (name, surname, number): ");
        String field = scanner.nextLine();
        System.out.printf("Enter %s: ", field);
        CONSUMER_MAP.get(field).accept(contact, scanner.nextLine());
        if (field.equals("number")) {
            alertWrongNumber(contact);
        }
        System.out.println("The record updated!");
    }
}
