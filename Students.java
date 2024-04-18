import java.util.ArrayList;
import java.util.List;

public class Students {
    private static List<Student> allStudents = new ArrayList<>();

    public static void promoteAllStudents() {
        for (Student student : allStudents) {
            student.promoteToNextSemester();
        }
    }

    public static void displayInfoAboutAllStudents() {
        for (Student student : allStudents) {
            student.displayInfo();
        }
    }

    public static void addStudent(Student student) {
        allStudents.add(student);
    }
}


