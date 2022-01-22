package damain;

import java.util.*;

public class Lecture {
    private int pass;
    private String title;
    private List<Integer> scores = new ArrayList<>();

    public Lecture(int pass, String title, Integer ...score) {
        this.pass = pass;
        this.title = title;
        this.scores = Arrays.asList(score);
    }

    //average 학생 평균 성적 계산
    public double average() {
        return scores.stream().
                mapToInt(o -> o.intValue()).
                average().
                orElse(0);
    }

    //evaluate 강의 이수한 학생수, 낙제한 학생 수
    public String evaluate() {
        return String.format("Pass: %d Fail:%d", passCount(), failCount());
    }

    //getScores 학생 전체 성적
    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    private long passCount() {
        return scores.stream().
                filter(o -> o.intValue() >= pass).
                count();
    }

    private long failCount() {
        return scores.size() - passCount();
    }


}
