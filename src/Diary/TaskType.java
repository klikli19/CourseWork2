package Diary;

public enum TaskType {
    P ("личная"),
    W ("рабочая");

    public String type;

    TaskType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
