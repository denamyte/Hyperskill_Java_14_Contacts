package contacts.action.actions.factories.org;

import contacts.action.actions.factories.BasicContactFactoryMethod;
import contacts.contact.BaseContact;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateOrgContactFactoryMethod extends BasicOrgContactFactoryMethod {

    private static final Map<String, Consumer<UpdateOrgContactFactoryMethod>> UPD_METHODS = Map.of(
            "name", BasicOrgContactFactoryMethod::addName,
            "address", BasicOrgContactFactoryMethod::addAddress,
            "number", BasicContactFactoryMethod::addNumber
    );

    public UpdateOrgContactFactoryMethod(Scanner scanner) {
        super(scanner);
    }

    @Override
    public BaseContact updateContact() {
        System.out.print("Select a field (name, address, number): ");

        UPD_METHODS.get(scanner.nextLine()).accept(this);
        return contact;
    }
}
