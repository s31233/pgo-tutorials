import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Student s=new Student("John", "Doe", "doe@wp.pl", "Warsaw, Zlota 12", "333-322-222", new Date(1980, 1, 1));
        //student get the indexNumber automatically assigned
        StudyProgramme it=new StudyProgramme("IT", "AAA", 7, 5);
        //7 is the number of semesters, 5 - number of possible ITN's before being allowed to be promoted to next semester
        s.enrollStudyProgramme(it);
        //we assign the student to the first semester by default
        s.addGrade(5, "PGO");
        s.addGrade(2, "APBD");

        Students.promoteAllStudents();
        //We check the current semester for each student
        Students.displayInfoAboutAllStudents();
    }
}