package contacts;

import java.util.ArrayList;
import java.util.Collection;

public class Contacts {
    private final Collection<Contact> storage = new ArrayList<>();

    public void saveContact(Contact contact) {
        storage.add(contact);
    }
}
