package contacts.action;

public enum ActionEnum {
    ADD, REMOVE, EDIT, COUNT, LIST, EXIT;

    public static ActionEnum fromString(String s) {
        return valueOf(s.toUpperCase());
    }
}
