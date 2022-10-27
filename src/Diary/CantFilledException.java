package Diary;

public class CantFilledException extends Exception{
    public CantFilledException() {
    }

    public CantFilledException(String message) {
        super(message);
    }
}
