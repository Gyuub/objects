package damain;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture{
    public FormattedGradeLecture(String title, int pass, List<Grade> grades, List<Integer> score) {
        super(title, pass, grades, score);
    }

    public String formatAverage(){
        return String.format("Avg: %1.1f", super.average());
    }
}
