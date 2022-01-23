import damain.*;

import java.util.Arrays;

/**
 * 학생 성적을 계산하는 프로그램
 *
 * <pre>
 *
 * </pre>
 *
 * @author Hman
 * @version 1.0.0
 * 작성일 2022-01-22
 */
public class Main {

    public static void main(String[] args) {
//        이수_기준_70점();
//        강의_등급별_통계();
//        전체_평균_점수();
//        전체_등급별_평균_점수();
        교수_Lecture();
        교수_GradeLecture();
        부모_클래스_메시지_전송();

    }

    public static void 부모_클래스_메시지_전송(){
        FormattedGradeLecture lecture = new FormattedGradeLecture("오브젝트",
                70,
                Arrays.asList(
                        new Grade("S", 95, 90),
                        new Grade("A", 90, 85),
                        new Grade("B", 85, 80)
                ),
                Arrays.asList(50,60,70,80));
        System.out.println(lecture.formatAverage());
    }

    public static void 교수_Lecture() {
        Professor professor = new Professor("다익스트라",
                new Lecture("알고리즘",
                        70, Arrays.asList(50, 60, 70, 80, 90)));
        System.out.println(professor.compileStatistics());
    }

    public static void 교수_GradeLecture() {
        Professor professor = new Professor("다익스트라",
                new GradeLecture("알고리즘",
                        70,
                        Arrays.asList(new Grade("A", 90, 85),
                                new Grade("B", 85, 80),
                                new Grade("C", 80, 75)),
                        Arrays.asList(50, 60, 70, 80, 90)));
        System.out.println(professor.compileStatistics());
    }

    public static void 이수_기준_70점() {
        Lecture lecture = new Lecture("오브젝트", 70, Arrays.asList(50, 60, 70, 80, 90));
        String evaluration = lecture.evaluate();
        System.out.println(lecture.getScores());
    }

    public static void 강의_등급별_통계() {
        GradeLecture gradeLecture = new GradeLecture("오브젝트", 70,
                Arrays.asList(new Grade("A", 90, 85),
                        new Grade("B", 85, 80),
                        new Grade("C", 80, 75)), Arrays.asList(50, 60, 70, 80, 90));
        String evaluration = gradeLecture.evaluate();
        System.out.println(evaluration);
    }

    public static void 전체_평균_점수() {
        GradeLecture gradeLecture = new GradeLecture("오브젝트", 70,
                Arrays.asList(new Grade("A", 90, 85),
                        new Grade("B", 85, 80),
                        new Grade("C", 80, 75)), Arrays.asList(50, 60, 70, 80, 90));
        String evaluration = gradeLecture.evaluate();
        System.out.println(gradeLecture.average());
    }

    public static void 전체_등급별_평균_점수() {
        GradeLecture gradeLecture = new GradeLecture("오브젝트", 70,
                Arrays.asList(
                        new Grade("S", 95, 90),
                        new Grade("A", 90, 85),
                        new Grade("B", 85, 80),
                        new Grade("C", 80, 75)), Arrays.asList(60, 70, 80, 90, 92, 93));
        String evaluration = gradeLecture.evaluate();
        System.out.println(gradeLecture.average("A"));
    }

}
