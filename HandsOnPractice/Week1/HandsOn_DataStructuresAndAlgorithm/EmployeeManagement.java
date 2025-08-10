class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee(" + employeeId + ", " + name + ", " + position + ", ₹" + salary + ")";
    }
}

public class EmployeeManagement {
    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int count = 0;

    // Add an employee
    public static void addEmployee(Employee e) {
        if (count < MAX) {
            employees[count++] = e;
            System.out.println("Added: " + e);
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Search employee by ID
    public static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all employees
    public static void listEmployees() {
        System.out.println("Employee List:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public static void deleteEmployee(int id) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--count] = null;
        System.out.println("Deleted employee with ID " + id);
    }

    public static void main(String[] args) {
        addEmployee(new Employee(101, "Alice", "Manager", 75000));
        addEmployee(new Employee(102, "Bob", "Developer", 55000));
        addEmployee(new Employee(103, "Charlie", "Designer", 50000));

        listEmployees();

        System.out.println("\nSearching for ID 102:");
        Employee found = searchEmployee(102);
        System.out.println(found != null ? found : "Employee not found");

        System.out.println("\nDeleting ID 102:");
        deleteEmployee(102);
        listEmployees();
    }
}
