package Diary;

import java.time.LocalDate;
import java.util.*;

public class TaskList{
    private final Map<Integer, Task> taskMap;

    public TaskList() {
        this.taskMap = new LinkedHashMap<>();;
    }

    public void addTask(Task task) {
        if (taskMap.containsKey(task.getId())){
            System.out.println("Такая задача есть");
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


    public List<Task>  getTaskOfDate(LocalDate date) {
        List<Task> list = new ArrayList<>();
        for (Integer integer : taskMap.keySet()) {
            if (taskMap.get(integer).nextTime(date)) {
                list.add(taskMap.get(integer));
            }
        }

        return  list;
    }
}

