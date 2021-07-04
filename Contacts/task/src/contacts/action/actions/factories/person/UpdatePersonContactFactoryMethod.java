package contacts.action.actions.factories.person;

import contacts.action.actions.factories.BasicContactFactoryMethod;
import contacts.contact.BaseContact;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdatePersonContactFactoryMethod extends BasicPersonContactFactoryMethod {

    private static final Map<String, Consumer<UpdatePersonContactFactoryMethod>> UPD_METHODS = Map.of(
            "name", BasicPersonContactFactoryMethod::addName,
            "surname", BasicPersonContactFactoryMethod::addSurname,
            "birth", BasicPersonContactFactoryMethod::addBirthDate,
            "gender", BasicPersonContactFactoryMethod::addGender,
            "number", BasicContactFactoryMethod::addNumber
    );

    public UpdatePersonContactFactoryMethod(Scanner scanner) {
        super(scanner);
    }

    @Override
    public BaseContact updateContact() {
        System.out.print("Select a field (name, surname, birth, gender, number): ");

        UPD_METHODS.get(scanner.nextLine()).accept(this);
        return contact;
    }
}
