package contacts.contact;

import java.time.LocalDateTime;

public abstract class BaseContact {
    private String name;
    private String phone;
    private LocalDateTime timeCreated;
    private LocalDateTime timeLastEdit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = matchPhoneTemplate(phone) ? phone : null;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void iniTimeCreated() {
        timeCreated = LocalDateTime.now();
        timeLastEdit = timeCreated;
    }

    public LocalDateTime getTimeLastEdit() {
        return timeLastEdit;
    }

    public void updateTimeLastEdit() {
        timeLastEdit = LocalDateTime.now();
    }

    private static boolean matchPhoneTemplate(String phone) {
        return phone.matches("^\\+?(((\\(\\w+\\))([- ]\\w{2,})?)|((\\w+)([- ]\\(\\w{2,}\\))?))([- ]\\w{2,})*$");
    }

    protected <T> String checkData(T data) {
        return data == null ? "[no data]" : data.toString();
    }

    public abstract String getListTitle();
}
