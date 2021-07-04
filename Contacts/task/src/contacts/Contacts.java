package contacts;

import contacts.contact.BaseContact;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Contacts {
    private final List<BaseContact> storage = new ArrayList<>();

    public void saveContact(BaseContact contact) {
        storage.add(contact);
    }

    public int size() {
        return storage.size();
    }

    public void remove(int index) {
        storage.remove(index);
    }

    public BaseContact getContactByIndex(int index) {
        return storage.get(index);
    }

    @Override
    public String toString() {
        return IntStream.rangeClosed(1, size())
                .mapToObj(i -> String.format("%d. %s", i, storage.get(i - 1).getListTitle()))
                .collect(Collectors.joining("\n"));
    }
}
