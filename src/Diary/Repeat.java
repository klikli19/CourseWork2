package Diary;

public enum Repeat {
    O ("Без повтора"),
    D ("Повтор завтра"),
    W ("Повтор через месяц"),
    M ("Повтор через месяц"),
    A ("Повтор через год");

    private final String name;

    Repeat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
