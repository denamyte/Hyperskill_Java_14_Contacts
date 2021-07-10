package contacts.contact;

import java.util.Locale;

public class OrganizationContact extends BaseContact {

    private static final long serialVersionUID = -3862778480219431552L;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getListTitle() {
        return getName();
    }

    @Override
    public void updateSearchField() {
        searchField = String.join("|||", name, phone, address).toLowerCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return "Organization name: " + name + "\n"
                + "Address: " + address + "\n"
                + super.toString();
    }
}
