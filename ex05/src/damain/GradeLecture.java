package damain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GradeLecture extends Lecture {
    private List<Grade> grades = new ArrayList<>();

    public GradeLecture(int pass, String title, List<Grade> grades, Integer... score) {
        super(pass, title, score);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradeStatistics();
    }


    public double average(String gradeName) {
        return grades.stream().
                filter(o -> o.isName(gradeName)).
                findFirst().
                map(grade -> gradeAverage(grade)).orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream().
                filter(o -> grade.include(o)).
                mapToInt(integer -> integer.intValue()).
                average().
                orElse(0d);
    }


    private String gradeStatistics() {
        return grades.stream().
                map(grade -> format(grade)).
                collect(Collectors.joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream().
                filter(score -> grade.include(score)).count();
    }
}
