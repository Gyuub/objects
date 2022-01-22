import damain.Lecture;

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
    }

    public static void 이수_기준_70점() {
        Lecture lecture = new Lecture(70, "오브젝트", 50, 60, 70, 80, 90);
        String evaluration = lecture.evaluate();
        System.out.println(evaluration);
    }
}
