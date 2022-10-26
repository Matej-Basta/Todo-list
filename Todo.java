import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Todo {
    
    private List<Task> todo;
    private int completedWork;

    public Todo() {

        todo = new ArrayList<>();
        completedWork = 0;

    }

    public void addTask(String description, int priority, int minutes) {
        
        if (priority < 1 || priority > 4) {
            System.out.println(description + " has invalid priority");
            return;
        }

        if (minutes < 0) {
            System.out.println(description + " has invalid workload");
            return;
        }

        todo.add(new Task(description, priority, minutes));

    }

    public void print() {
        
            System.out.println("Todo:");
            System.out.println("-----");

            if (todo.isEmpty()) {
                System.out.println("You're all done for today! #TodoZero");
            } else {

            for (Task task : todo) {
                System.out.println(task.toString());
            }
        }
        if (completedWork > 0) {
            System.out.println(completedWork + " minutes of work done!");
        }

    }

    public void completeTask(int index) {
        if (index < 0 || index > todo.size() - 1 || todo.isEmpty()) {
            System.out.println("Invalid index");
            return;
        }

        completedWork += todo.get(index).getWorkload();
        todo.remove(index);

    }

    public void printPriority(int limit) {
        System.out.println("Filtered todo:");
        System.out.println("--------------");

        int count = 0;

        for (Task task : todo) {
            if (task.getPriority() <= limit) {
                System.out.println(task);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No tasks with given priority");
        }
    }

    public void printPrioritized() {
        System.out.println("Prioritized todo:");
        System.out.println("-----------------");

        Comparator<Task> com = new Comparator<>() {
            public int compare(Task t1, Task t2) {
                if (t1.getPriority() > t2.getPriority()) {
                    return 1;
                } else if (t1.getPriority() < t2.getPriority()) {
                    return -1;
                } else {
                    if (t1.getWorkload() > t2.getWorkload()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };

        Collections.sort(todo, com);

        for (Task task : todo) {
            System.out.println(task);
        }
    }

}
