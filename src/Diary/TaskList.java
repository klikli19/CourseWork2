package Diary;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaskList{
    private  Map<Integer, Task> taskMap;

    public TaskList() {
        this.taskMap = new LinkedHashMap<>();;
    }

    public void addTask(Task task) throws CantFilledException {
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
}
