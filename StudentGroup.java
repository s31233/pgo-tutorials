import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
    public String name;
    public List<Student> students = new ArrayList<>();

    public StudentGroup(String name) {
        this.name = name;
    }
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}