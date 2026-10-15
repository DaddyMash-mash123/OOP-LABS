class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        // EXPLAIN: Initialize the common employee information.
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculatePay() {
        // EXPLAIN: The default employee receives the base salary.
        return baseSalary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        // EXPLAIN: Initialize common fields through the superclass constructor.
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        // EXPLAIN: A manager earns the base salary plus a bonus.
        return baseSalary + bonus;
    }
}

class Intern extends Employee {
    public Intern(String name, double stipend) {
        // EXPLAIN: The intern's stipend is stored as the base salary.
        super(name, stipend);
    }

    @Override
    public double calculatePay() {
        // EXPLAIN: An intern receives the stipend without an extra bonus.
        return baseSalary;
    }
}

public class PayrollDemo {
    public static void main(String[] args) {
        // EXPLAIN: The array holds different Employee subclass objects.
        Employee[] employees = {
            new Employee("Tariro", 800),
            new Manager("Farai", 1500, 300),
            new Intern("Rudo", 400)
        };

        double totalPayroll = 0;

        // EXPLAIN: The same loop calculates pay for every employee type.
        for (Employee employee : employees) {
            double pay = employee.calculatePay();
            System.out.println(employee.name + ": " + pay);
            totalPayroll += pay;
        }

        System.out.println("Total payroll: " + totalPayroll);
    }
}



