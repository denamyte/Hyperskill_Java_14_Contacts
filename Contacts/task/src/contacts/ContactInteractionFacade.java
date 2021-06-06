package contacts;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInteractionFacade {

    public static void stage1() {
        Scanner scanner = new Scanner(System.in);
        List<String> data = Stream.of(
                "Enter the name of the person:",
                "Enter the surname of the person:",
                "Enter the number:")
                .map(prompt -> {
                    System.out.println(prompt);
                    return scanner.nextLine();
                }).collect(Collectors.toList());

//        Contact contact = new Contact(data.get(0), data.get(1), data.get(2));
//        Contacts contacts = new Contacts();
//        contacts.saveContact(contact);
//        ...

        System.out.println("\nA record created!\nA Phone Book with a single record created!");
    }
}
