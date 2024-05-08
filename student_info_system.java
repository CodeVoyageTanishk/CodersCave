import java.util.*;
class Student {
    private String id;
    private String name;
    private int age;
    private String address;
    public Student(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\nAddress: " + address;
    }
}
class Course {
    private String courseId;
    private String courseName;
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }
    public String getCourseId() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    @Override
    public String toString() {
        return "Course ID: " + courseId + "\nCourse Name: " + courseName;
    }
}
public class StudentInformationSystem {
    private List<Student> students;
    private List<Course> courses;
    public StudentInformationSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }
    public void displayAllStudents() {
        System.out.println("List of all students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added successfully!");
    }
    public void displayAllCourses() {
        System.out.println("List of all courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentInformationSystem sis = new StudentInformationSystem();
        while (true) {
            System.out.println("\nStudent Information System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Add Course");
            System.out.println("4. Display All Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = scanner.next();
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student address: ");
                    String address = scanner.nextLine();
                    Student student = new Student(id, name, age, address);
                    sis.addStudent(student);
                    break;
                case 2:
                    sis.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter course ID: ");
                    String courseId = scanner.next();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    Course course = new Course(courseId, courseName);
                    sis.addCourse(course);
                    break;
                case 4:
                    sis.displayAllCourses();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
