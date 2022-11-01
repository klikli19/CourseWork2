import Diary.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
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
                            break;
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
        try {
            System.out.print("Введите название задачи: ");
            String header = scanner.next();
            scanner.nextLine();
            System.out.print("Введите описание задачи: ");
            String description = scanner.nextLine();
            System.out.print("Выберите тип задачи: \n");
            System.out.print(
                    """
                            1 - личная,
                            2 - рабочая,
                            """);
            int taskTypeNum = scanner.nextInt();
            TaskType.getConstant(taskTypeNum);
            System.out.println("Введите дату и время в формате год-мес-день час:мин : ");
            LocalDate dateTask = LocalDate.parse(scanner.next());
            LocalTime timeTask = LocalTime.parse(scanner.next());
            LocalDateTime startTime = LocalDateTime.of(dateTask, timeTask);
            System.out.print("Выберете повторяемость: \n");
            System.out.println(
                    """
                            1 - не повторяется,
                            2 - через день,
                            3 - через неделю,
                            4 - через месяц,
                            5 - через год.
                            """);
            int numRepeat = scanner.nextInt();
            Repeat.getConstant(numRepeat);

            diary.addTask(new Task(header, description, TaskType.getConstant(taskTypeNum), startTime, Repeat.getConstant(numRepeat)));
        } catch (CantFilledException e) {
            System.out.println("Не все заполнено");
            System.out.println(e.getMessage());
        }
    }


    private static void delTask(Scanner scanner, TaskList diary)throws Exception {
        try {
            System.out.println("Введине номер ID задачи: ");
            int id = scanner.nextInt();
            diary.removeTask(id);
        } catch (Exception e) {
            System.out.println("Неправильно введен ID");
            System.out.println(e.getMessage());
        }
    }

    private static void listTask(TaskList diary) {
        System.out.println("Получить все задачи : ");
        diary.printTasks();
    }

    private static void listTaskOfDate(Scanner scanner,TaskList diary) {
        System.out.println("Получить задачи на указанный день: ");
        LocalDate dateTask = LocalDate.parse(scanner.next());
        System.out.println(diary.getTaskOfDate(dateTask));

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