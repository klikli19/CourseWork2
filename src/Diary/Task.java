package Diary;

import java.time.LocalDate;
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
        this.header = header;
        this.description = description;
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

    public void setHeader(String header) {
            this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public void setDescription(String description) {
            this.description = description;
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
                ", " + repeat.getName() +
                '}';

    }

    public boolean nextTime(LocalDate localDate) {
        switch (repeat) {
            case ONE_DAILY:
                return startTime.toLocalDate().isEqual(localDate);

            case DAILY:
                while (startTime.toLocalDate().isBefore(localDate)&& !startTime.toLocalDate().isEqual(localDate)){
                    startTime = startTime.plusDays(1);
                }
                return startTime.toLocalDate().isBefore(localDate);

            case WEEKLY:
                while (startTime.toLocalDate().isBefore(localDate)&& !startTime.toLocalDate().isEqual(localDate)){
                    startTime = startTime.plusWeeks(1);
                }
                return startTime.toLocalDate().isEqual(localDate);
            case MONTHLY:
                while (startTime.toLocalDate().isBefore(localDate)&&  !startTime.toLocalDate().isEqual(localDate)){
                    startTime = startTime.plusMonths(1);
                }
                return startTime.toLocalDate().isEqual(localDate);
            case ANNUALLY:
                while (startTime.toLocalDate().isBefore(localDate)&& !startTime.toLocalDate().isEqual(localDate)){
                    startTime = startTime.plusYears(1);
                }
                return startTime.toLocalDate().isEqual(localDate);
            }
            return false;
    }
}


