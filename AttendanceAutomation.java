import java.util.Scanner;

class Student {
    private String name;
    private boolean isPresent;

    public Student(String name) {
        this.name = name;
        this.isPresent = false; // default is absent
    }

    public String getName() {
        return name;
    }

    public void markPresent() {
        this.isPresent = true;
    }

    public void markAbsent() {
        this.isPresent = false;
    }

    public String getAttendanceStatus() {
        return isPresent ? "Present" : "Absent";
    }
}

public class AttendanceAutomation {

    private Student[] students;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        students = new Student[numStudents];

        // Taking student names
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            students[i] = new Student(name);
        }

        // Mark attendance
        markAttendance(scanner);

        // Show attendance report
        showReport();

        scanner.close();
    }

    private void markAttendance(Scanner scanner) {
        System.out.println("\n--- Mark Attendance (Y/N) ---");

        for (Student student : students) {
            while (true) {
                System.out.print("Is " + student.getName() + " present? (Y/N): ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("Y")) {
                    student.markPresent();
                    break;
                } else if (input.equalsIgnoreCase("N")) {
                    student.markAbsent();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                }
            }
        }
    }

    private void showReport() {
        System.out.println("\n--- Attendance Report ---");
        for (Student student : students) {
            System.out.println(student.getName() + ": " + student.getAttendanceStatus());
        }
    }

    public static void main(String[] args) {
        AttendanceAutomation app = new AttendanceAutomation();
        app.start();
    }
}
