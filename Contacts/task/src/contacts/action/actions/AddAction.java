package contacts.action.actions;

import contacts.Contact;
import contacts.Contacts;
import contacts.action.ActionBase;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

@Deprecated
public class AddAction extends ActionBase {

    private static final Map<String, BiConsumer<Contact.Builder, String>> CONSUMER_MAP = new LinkedHashMap<>() {{
        put("Enter the name: ", Contact.Builder::setName);
        put("Enter the surname: ", Contact.Builder::setSurname);
        put("Enter the number: ", Contact.Builder::setPhone);
    }};


    public AddAction(Contacts contacts, Scanner scanner) {
        super(contacts, scanner);
    }

    @Override
    public void execute() {
        Contact.Builder builder = new Contact.Builder();
        CONSUMER_MAP.forEach((prompt, consumer) -> {
            System.out.print(prompt);
            consumer.accept(builder, scanner.nextLine());
        });
        Contact contact = builder.build();
        alertWrongNumber(contact);
        contacts.saveContact(contact);
        System.out.println("The record added.");
    }
}
