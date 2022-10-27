package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task implements Repeatable {
    private static int countId = 1;
    private final int id;
    private String header;
    private String description;
    private final TaskType taskType;
    private final LocalDateTime startTime;

    public Task(String header, String description, TaskType taskType, LocalDateTime startTime) throws CantFilledException {
        setHeader(header);
        setDescription(description);
        this.taskType = taskType;
        this.startTime = startTime;
        this.id = countId++;
    }



    public String getHeader() {
        return header;
    }

    public void setHeader(String header) throws CantFilledException {
        if (header == null || header.isBlank()) {
            throw new CantFilledException("Заполните, пожалуйста, заголовок");
        } else {
            this.header = header;
        }
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public void setDescription(String description) throws CantFilledException {
        if (description == null || description.isBlank()) {
            throw new CantFilledException("В Вашей задаче не заполнено описание");
        } else {
            this.description = description;
        }
    }

    public TaskType getTaskType() {
        return taskType;
    }

    @Override
    public String toString() {
        return "Задача {" +
                "№ =" + id +
                ", заголовок ='" + header + '\'' +
                ", описание ='" + description + '\'' +
                ", тип задачи =" + taskType.getType() +
                ", дата =" + startTime +
                '}';
    }

    @Override
    public void getOneTime() {
        System.out.println("Повтор задачи не задан");
    }

    @Override
    public void getDaily() {
        System.out.println(startTime.plusDays(1) + "- дата повтора задачи");
    }

    @Override
    public void getWeekly() {
        System.out.println(startTime.plusWeeks(1) + "- дата повтора задачи");
    }

    @Override
    public void getMonthly() {
        System.out.println(startTime.plusMonths(1) + "- дата повтора задачи");
    }

    @Override
    public void getAnnual() {
        System.out.println(startTime.plusYears(1) + "- дата повтора задачи");

    }
}
