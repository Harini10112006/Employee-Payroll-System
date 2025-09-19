import java.util.*;

class Employee {
    private int id;
    private String name;
    private double basicPay;
    private double allowance;
    private double deduction;
    private int workingDays;

    // Constructor
    public Employee(int id, String name, double basicPay) {
        this.id = id;
        this.name = name;
        this.basicPay = basicPay;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getBasicPay() { return basicPay; }
    public void setAllowance(double allowance) { this.allowance = allowance; }
    public void setDeduction(double deduction) { this.deduction = deduction; }
    public void setWorkingDays(int days) { this.workingDays = days; }

    // Salary Calculation
    public double calculateSalary() {
        return (basicPay + allowance - deduction);
    }

    // Payslip
    public void generatePayslip() {
        System.out.println("\n--- Payslip for " + name + " ---");
        System.out.println("Employee ID: " + id);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("Allowance: " + allowance);
        System.out.println("Deduction: " + deduction);
        System.out.println("Net Salary: " + calculateSalary());
        System.out.println("-----------------------------\n");
    }
}

class PayrollSystem {
    private HashMap<Integer, Employee> employees = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Basic Pay: ");
        double basic = sc.nextDouble();

        employees.put(id, new Employee(id, name, basic));
        System.out.println("Employee Added Successfully!");
    }

    // View Employees
    public void viewEmployees() {
        System.out.println("\n--- Employee List ---");
        for(Employee e : employees.values()) {
            System.out.println(e.getId() + " - " + e.getName());
        }
    }

    // Record Attendance & Payroll
    public void recordPayroll() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        if(employees.containsKey(id)) {
            Employee e = employees.get(id);
            System.out.print("Enter Allowance: ");
            e.setAllowance(sc.nextDouble());
            System.out.print("Enter Deduction: ");
            e.setDeduction(sc.nextDouble());
            System.out.print("Enter Working Days: ");
            e.setWorkingDays(sc.nextInt());
            System.out.println("Payroll Updated Successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Generate Payslip
    public void generatePayslip() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        if(employees.containsKey(id)) {
            employees.get(id).generatePayslip();
        } else {
            System.out.println("Employee not found!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem ps = new PayrollSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Payroll System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Record Payroll");
            System.out.println("4. Generate Payslip");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1: ps.addEmployee(); break;
                case 2: ps.viewEmployees(); break;
                case 3: ps.recordPayroll(); break;
                case 4: ps.generatePayslip(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid Choice!");
            }
        } while(choice != 5);
    }
}
