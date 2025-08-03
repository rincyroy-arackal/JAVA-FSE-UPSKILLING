class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task(" + taskId + ", " + taskName + ", " + status + ")";
    }
}

class TaskNode {
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManager {
    TaskNode head = null;

    // Add task to end of list
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Added: " + task);
    }

    // Traverse and display tasks
    public void displayTasks() {
        TaskNode temp = head;
        if (temp == null) {
            System.out.println("Task list is empty.");
            return;
        }
        System.out.println("Task List:");
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Search for a task by ID
    public Task searchTask(int taskId) {
        TaskNode temp = head;
        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Delete a task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Deleted task with ID: " + taskId);
            return;
        }

        TaskNode prev = null;
        TaskNode curr = head;

        while (curr != null && curr.task.taskId != taskId) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Task not found.");
        } else {
            prev.next = curr.next;
            System.out.println("Deleted task with ID: " + taskId);
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task(1, "Design UI", "Pending"));
        manager.addTask(new Task(2, "Develop Backend", "In Progress"));
        manager.addTask(new Task(3, "Write Tests", "Pending"));

        manager.displayTasks();

        System.out.println("\nSearch for task ID 2:");
        Task found = manager.searchTask(2);
        System.out.println(found != null ? found : "Task not found");

        System.out.println("\nDeleting task ID 2:");
        manager.deleteTask(2);
        manager.displayTasks();
    }
}
