import com.sun.jdi.connect.IllegalConnectorArgumentsException;

import java.util.ArrayList;
import java.util.List;


public class Student {
    public String fname, lname, indexNumber, email, address;
    public List<Double> grades = new ArrayList<>();

    public Student(String fname, String lname, String indexNumber, String email, String address) {
        this.fname = fname;
        this.lname = lname;
        this.indexNumber = indexNumber;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", grades=" + grades +
                '}';
    }

    public double obliczSrednia() {
        double average;
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("Brakuje ocen");
        }else if (grades.size() > 20) {
            throw new IllegalArgumentException("Nie można dodać więcej niż 20 ocen");
        } else {

            double suma = 0;
            for (Double grade : grades) {
                suma += grade;
            }
            //sumujemy wszystkie liczby w ArrayList za pomoca pętli i następnie dzielimy przez liczbę ocen
            average = suma / grades.size();
        }
        return average;
    }
public void addGrade(double grade) {
    this.grades.add(grade);
}
}
