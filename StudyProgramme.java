// nazwa, opis, liczbasemestrow i maksymalna ilosc itnow

public class StudyProgramme {
    private String name;
    private String description;
    private int totalSemesters;
    private int maxITN;

    public StudyProgramme(String name, String description, int totalSemesters, int maxITN) {
        this.name = name;
        this.description = description;
        this.totalSemesters = totalSemesters;
        this.maxITN = maxITN;
    }

    public int getTotalSemesters() {
        return totalSemesters;
    }

    public boolean canPromote(int currentSemester) {
        return currentSemester < totalSemesters;
    }
}


