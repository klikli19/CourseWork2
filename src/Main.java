import Diary.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws CantFilledException {
        TaskList diary = new TaskList();

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, diary);
                            break;
                        case 2:
                            delTask(scanner, diary);
                            break;
                        case 3:
                            listTask(diary);
                            break;
                        case 4:
                            listTaskOfDate(scanner, diary);
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }


    private static void inputTask(Scanner scanner, TaskList diary) throws CantFilledException {
        System.out.print("Введите название задачи: ");
        String header = scanner.next();
        System.out.print("Введите описание задачи: ");
        String description = scanner.next();
        System.out.print("Выберите тип задачи: \n");
        System.out.println(
                """
                        P - личная,
                        W - рабочая,
                        """);
        TaskType taskType = TaskType.valueOf(scanner.next());
        System.out.println("Введите дату и время в формате год-мес-день час:мин : ");
        LocalDate dateTask = LocalDate.parse(scanner.next());
        LocalTime timeTask = LocalTime.parse(scanner.next());
        System.out.println("Выберете повторяемость:");
        System.out.println(
                """
                        O - не повторяется,
                        D - через день,
                        W - через неделю,
                        M - через месяц,
                        A - через год.
                        """);
        Repeat repeat = Repeat.valueOf(scanner.next());
        LocalDateTime startTime = LocalDateTime.of(dateTask, timeTask);
        diary.addTask(new Task(header,description, taskType, startTime, repeat));


    }


    private static void delTask(Scanner scanner, TaskList diary){
        System.out.println("Введине номер ID задачи: ");
        int id = scanner.nextInt();
        diary.removeTask(id);
    }

    private static void listTask(TaskList diary) {
        System.out.println("Получить задачи на день: ");
        diary.printTasks();
    }

    private static void listTaskOfDate(Scanner scanner,TaskList diary) {
        System.out.println("Получить задачи на указанный день: ");
        LocalDate dateTask = LocalDate.parse(scanner.next());
        diary.getTaskOfDate(dateTask);
    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачи на день
                        4. Получить задачи на указанный день
                        0. Выход
                        """
        );
    }
}