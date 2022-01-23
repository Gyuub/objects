package damain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GradeLecture extends Lecture {
    private List<Grade> grades = new ArrayList<>();

    public GradeLecture(String title, int pass, List<Grade> grades, List<Integer> score) {
        super(title, pass, score);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradeStatistics();
    }

    @Override
    public String getEvaluationMethod() {
        return "Grade";
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
