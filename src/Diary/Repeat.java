package Diary;

public enum Repeat {
    EMPTY("NULL",0),
    ONE_DAILY ("Без повтора", 1),
    DAILY ("Повтор завтра", 2),
    WEEKLY ("Повтор через месяц", 3),
    MONTHLY ("Повтор через месяц", 4),
    ANNUALLY("Повтор через год", 5);

    private final String name;
    private final int constantEnum;

    Repeat(String name, int i) {
        this.name = name;
        this.constantEnum = i;
    }

    public String getName() {
        return name;
    }

    public int getConstantEnum() {
        return constantEnum;
    }

    public static Repeat getConstant(int i){
        return values()[i];
    }
}
