package Diary;

public enum TaskType {
    EMPTY("NULL",0),
    PERSONAL("личная", 1),
    WORK ("рабочая",2);

    private final String type;
    private final int constantEnum;



    TaskType(String type, int i) {
        this.type = type;
        this.constantEnum = i;
    }

    public int getConstantEnum() {
        return constantEnum;
    }

    public String getType() {
        return type;
    }

    public static TaskType getConstant(int i){
        return values()[i];
    }


}
