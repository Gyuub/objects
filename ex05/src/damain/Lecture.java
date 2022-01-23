package damain;

import java.util.*;

public class Lecture {
    private String title;
    private int pass;
    private List<Integer> scores = new ArrayList<>();

    public Lecture(String title, int pass, List<Integer> score) {
        this.pass = pass;
        this.title = title;
        this.scores = score;
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

    public String stats(){
        return String.format("Title: $s, Evaluation Method: %s", title, getEvaluationMethod());
    }

    public String getEvaluationMethod(){
        return "Pass or Fail";
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
