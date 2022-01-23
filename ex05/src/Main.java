import damain.Grade;
import damain.GradeLecture;
import damain.Lecture;

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
        이수_기준_70점();
        강의_등급별_통계();
        전체_평균_점수();
        전체_등급별_평균_점수();
    }

    public static void 이수_기준_70점() {
        Lecture lecture = new Lecture(70, "오브젝트", 50, 60, 70, 80, 90);
        String evaluration = lecture.evaluate();
        System.out.println(lecture.getScores());
    }

    public static void 강의_등급별_통계() {
        GradeLecture gradeLecture = new GradeLecture(70, "오브젝트",
                Arrays.asList(new Grade("A", 90, 85),
                                new Grade("B", 85, 80),
                                new Grade("C", 80, 75)), 60, 70, 80, 90);
        String evaluration = gradeLecture.evaluate();
        System.out.println(evaluration);
    }

    public static void 전체_평균_점수(){
        GradeLecture gradeLecture = new GradeLecture(70, "오브젝트",
                Arrays.asList(new Grade("A", 90, 85),
                        new Grade("B", 85, 80),
                        new Grade("C", 80, 75)), 60, 70, 80, 90);
        String evaluration = gradeLecture.evaluate();
        System.out.println(gradeLecture.average());
    }
    public static void 전체_등급별_평균_점수(){
        GradeLecture gradeLecture = new GradeLecture(70, "오브젝트",
                Arrays.asList(
                        new Grade("S", 95, 90),
                        new Grade("A", 90, 85),
                        new Grade("B", 85, 80),
                        new Grade("C", 80, 75)), 60, 70, 80, 90,92,93);
        String evaluration = gradeLecture.evaluate();
        System.out.println(gradeLecture.average("A"));
    }

}
