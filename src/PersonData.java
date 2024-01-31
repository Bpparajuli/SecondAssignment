import java.util.Date;

class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPersonInfo() {
        return "Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

class Employee extends Person {
    private String position;
    private double salary;
    private Date dateHired;

    public Employee(String name, String address, String phoneNumber, String email, String position, double salary, Date dateHired) {
        super(name, address, phoneNumber, email);
        this.position = position;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getEmployeeInfo() {
        return super.getPersonInfo() + ", Position: " + position + ", Salary: " + salary + ", Date Hired: " + dateHired;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, String address, String phoneNumber, String email,
                            String position, double hourlyRate, Date dateHired) {
        super(name, address, phoneNumber, email, position, 0, dateHired);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double calculateEarnings() {
        return hourlyRate * hoursWorked;
    }

    public String getPartTimeEmployeeInfo() {
        return super.getEmployeeInfo() + ", Hours Worked: " + hoursWorked + ", Earnings: $" + calculateEarnings();
    }
}

public class PersonData {
    public static void main(String[] args) {
        // Testing the classes
        Employee employee = new Employee("Jane Smith", "456 Oak Ave",
                "456-789-0123", "jane@example.com", "Office Manager",
                50000, new Date(2022, 1, 15));
        System.out.println(employee.getEmployeeInfo());

        PartTimeEmployee partTime = new PartTimeEmployee("Bob Brown", "777 Walnut St",
                "333-444-5555", "bob@example.com", "Clerk",
                20, new Date(2024, 6, 30));
        partTime.setHoursWorked(30);
        System.out.println(partTime.getPartTimeEmployeeInfo());
    }
}
