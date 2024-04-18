import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Informacje o studentach wraz z metodami do zarządzania ich stanem
// - rejestracja na program studiów
// - dodawanie ocen
// - promocja do następnego semestru
// - wyświetlenie informacji
public class Student {
    private static int nextIndexNumber = 1;
    private String indexNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Date dateOfBirth;
    private StudyProgramme programme;
    private List<Grade> grades;
    private int currentSemester;

    public Student(String firstName, String lastName, String email, String address, String phoneNumber, Date dateOfBirth) {
        this.indexNumber = "s" + nextIndexNumber++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.grades = new ArrayList<>();
        this.currentSemester = 1;
    }

    public void enrollStudyProgramme(StudyProgramme programme) {
        this.programme = programme;
    }

    public void addGrade(int value, String subject) {
        Grade grade = new Grade(value, subject);
        grades.add(grade);
    }

    public void promoteToNextSemester() {
        if (currentSemester < programme.getTotalSemesters()) {
            currentSemester++;
        } else {
            // Ustawienie statusu na absolwenta
        }
    }

    public boolean isGraduate() {
        return currentSemester == programme.getTotalSemesters();
    }

    public void displayInfo() {
        // Wyświetlenie informacji o studencie
    }
}