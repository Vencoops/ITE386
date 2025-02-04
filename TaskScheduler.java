import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Task {
    private String name;
    private int delay;

    public Task(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public String getName() {
        return name;
    }

    public int getDelay() {
        return delay;
    }
}

public class TaskScheduler {
    private static Queue<Task> tasks = new LinkedList<>();

    public static void addTask(String name, int delay) {
        tasks.add(new Task(name, delay));
        System.out.println("Task '" + name + "' added with a delay of " + delay + " seconds.");
    }

    public static void runScheduler() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to run.");
            return;
        }
        System.out.println("Starting Task Scheduler...");
        while (!tasks.isEmpty()) {
            Task task = tasks.poll();
            System.out.println("Executing task: " + task.getName());
            try {
                Thread.sleep(task.getDelay() * 1000);
            } catch (InterruptedException e) {
                System.err.println("Task interrupted: " + task.getName());
            }
            System.out.println("Task '" + task.getName() + "' completed.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Run Scheduler");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter delay (seconds): ");
                    int delay = scanner.nextInt();
                    addTask(name, delay);
                    break;
                case 2:
                    runScheduler();
                    break;
                case 3:
                    System.out.println("Exiting Task Scheduler.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
