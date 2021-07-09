package contacts;

import contacts.contact.BaseContact;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Contacts implements Serializable {
    private static final long serialVersionUID = -6505540603895517770L;

    private final List<BaseContact> storage = new ArrayList<>();
    transient private String fileName;

    private Contacts(String fileName) {
        this.fileName = fileName;
    }

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

    public String getFileName() {
        return fileName;
    }

    public static Contacts createOrLoadFromFile(String fileName) throws IOException, ClassNotFoundException {
        if (fileName != null && Files.exists(Path.of(fileName))) {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))) {
                Contacts contacts = (Contacts) stream.readObject();
                contacts.fileName = fileName;
                return contacts;
            }
        }
        return new Contacts(fileName);
    }

    public void saveToFile() {
        if (fileName != null) {
            try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                stream.writeObject(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return IntStream.rangeClosed(1, size())
                .mapToObj(i -> String.format("%d. %s", i, storage.get(i - 1).getListTitle()))
                .collect(Collectors.joining("\n"));
    }
}
