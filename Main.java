
import java.io.*;
import java.util.*;

class AutoboxingDemo {
    public static void runSumDemo(Scanner sc) {
        System.out.println("Enter integers separated by spaces:");
        String input = sc.nextLine();
        String[] parts = input.split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : parts) {
            Integer num = Integer.parseInt(s);
            numbers.add(num);
        }
        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }
        System.out.println("Sum of integers = " + sum);
    }
}

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int studentID;
    String name;
    String grade;

    Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentID: " + studentID + ", Name: " + name + ", Grade: " + grade;
    }
}

class SerializationDemo {
    public static void runSerializationDemo() {
        try {
            Student s1 = new Student(101, "Aditya", "A");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"));
            oos.writeObject(s1);
            oos.close();
            System.out.println("Student object serialized to student.ser");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"));
            Student s2 = (Student) ois.readObject();
            ois.close();
            System.out.println("Deserialized Student: " + s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Employee {
    int id;
    String name;
    String designation;
    double salary;

    Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + designation + " | " + salary;
    }
}

class EmployeeManagement {
    private static final String FILE_NAME = "employees.txt";

    public static void addEmployee(Scanner sc) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Designation: ");
            String designation = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            Employee emp = new Employee(id, name, designation, salary);
            bw.write(emp.toString());
            bw.newLine();
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Employee Records:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No employee records found!");
        }
    }

    public static void runMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n========= Main Menu =========");
            System.out.println("1. Autoboxing & Sum of Integers");
            System.out.println("2. Student Serialization/Deserialization");
            System.out.println("3. Employee Management System");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    AutoboxingDemo.runSumDemo(sc);
                    break;
                case 2:
                    SerializationDemo.runSerializationDemo();
                    break;
                case 3:
                    EmployeeManagement.runMenu(sc);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        } while (option != 4);
        sc.close();
    }
}
