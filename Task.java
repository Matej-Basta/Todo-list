public class Task {

    private String description;
    private int priority;
    private int workload;

    public Task(String description, int priority, int workload) {
        this.description = description;
        this.workload = workload;
        this.priority = priority;
    }

    public String toString() {

        String textPriority = "";

        switch(priority) {
            case 1:
                textPriority = "very important";
                break;
            case 2:
                textPriority = "important";
                break;
            case 3:
                textPriority = "unimportant";
                break;
            case 4:
                textPriority = "after learn Portuguese";
                break;
        }

        return description + " takes " + workload + " minutes and has priority " + textPriority;
    }

    public int getWorkload() {
        return workload;
    }

    public int getPriority() {
        return priority;
    }

}