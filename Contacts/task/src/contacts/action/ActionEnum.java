package contacts.action;

public enum ActionEnum {
    ADD, REMOVE, EDIT, COUNT, INFO, EXIT;

    public static ActionEnum fromString(String s) {
        return valueOf(s.toUpperCase());
    }
}
