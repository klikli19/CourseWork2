package Diary;

public interface Repeatable {
    int ONE_TIME = 1;
    int DAILY = 2;
    int WEEKLY = 3;
    int MONTHLY = 4;
    int ANNUAL = 5;

    void getOneTime();
    void getDaily();
    void getWeekly();
    void getMonthly();
    void getAnnual();

}
