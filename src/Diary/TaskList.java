package Diary;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskList{
    private final Map<Integer, Task> taskMap;

    public TaskList() {
        this.taskMap = new LinkedHashMap<>();;
    }

    public void addTask(Task task) throws RuntimeException {
        if (taskMap.containsKey(task.getId())){
            throw new RuntimeException("Такая задача есть");
        } else {
            taskMap.put(task.getId(), task);
        }
    }

    public void removeTask(int id) {
        taskMap.remove(id);
    }

    public void printTasks() {
        for (Map.Entry<Integer, Task> taskEntry : taskMap.entrySet()) {
            System.out.println(taskEntry);
        }
    }

    public void getTaskOfDate(LocalDate localDate) {
        for (Task value : taskMap.values()) {
            if (value.getStartTime().toLocalDate().equals(localDate)){
                System.out.println(value);
            }
        }
    }
}

