package Diary;

import java.time.LocalDateTime;

public class Task implements Repeatable {
    private static int countId = 1;
    private final int id;
    private String header;
    private String description;
    private final TaskType taskType;
    private final Repeat repeat;
    private LocalDateTime startTime;

    public Task(String header, String description, TaskType taskType, LocalDateTime startTime, Repeat repeat) throws CantFilledException {
        setHeader(header);
        setDescription(description);
        this.taskType = taskType;
        this.startTime = startTime;
        this.repeat = repeat;
        this.id = countId++;
    }


    public LocalDateTime getStartTime() {
        return startTime;
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
                ", " + repeat.getName() + nextTime() +
                '}';

    }

    @Override
    public Repeat nextTime() {
        switch (repeat) {
            case O -> System.out.println(startTime.plusDays(0) + "Повтор задачи не задан");
            case D -> System.out.println(startTime.plusDays(1) + "- дата повтора задачи");
            case W -> System.out.println(startTime.plusWeeks(1) + "- дата повтора задачи");
            case M -> System.out.println(startTime.plusMonths(1) + "- дата повтора задачи");
            case A -> System.out.println(startTime.plusYears(1) + "- дата повтора задачи");
        }
        return repeat;
    }

}
