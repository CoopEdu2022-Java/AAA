public class java216 {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", "Software Engineer", 60000.0);

        System.out.println("Employee Information:");
        System.out.println(employee);

        // Calculate and apply a salary increase
        employee.calculateSalaryIncrease(10.0);
        System.out.println("\nAfter a 10% salary increase:");
        System.out.println(employee);

        // Update the job title
        employee.updateJobTitle("Senior Software Engineer");
        System.out.println("\nAfter updating the job title:");
        System.out.println(employee);
    }
}
class Employee {
    private String name;
    private String jobTitle;
    private double salary;

    public Employee(String name, String jobTitle, double salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void calculateSalaryIncrease(double percentage) {
        if (percentage > 0) {
            double increaseAmount = (percentage / 100) * salary;
            salary += increaseAmount;
        } else {
            System.out.println("Invalid percentage. Salary increase percentage should be greater than 0.");
        }
    }

    public void updateJobTitle(String newJobTitle) {
        this.jobTitle = newJobTitle;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nJob Title: " + jobTitle + "\nSalary: $" + salary;
    }

    
}
