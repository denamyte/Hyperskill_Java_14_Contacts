package contacts.action;

public class ActionInvoker {
    private Action action;

    public ActionInvoker(Action action) {
        this.action = action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void executeAction() {
        action.execute();
    }
}
