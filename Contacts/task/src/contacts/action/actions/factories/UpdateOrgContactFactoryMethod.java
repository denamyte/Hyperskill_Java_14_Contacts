package contacts.action.actions.factories;

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
    private String field;

    public UpdateOrgContactFactoryMethod(Scanner scanner) {
        super(scanner);
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public BaseContact updateContact() {
        UPD_METHODS.get(field).accept(this);
        return contact;
    }

    // TODO: 7/3/21 Modify this class and create UpdatePersonContactFactoryMethod
}
