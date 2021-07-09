package contacts.action;

public enum ActionName {
    ADD, LIST, SEARCH, COUNT, EXIT;

    public static ActionName fromString(String s) {
        return valueOf(s.toUpperCase());
    }
}
