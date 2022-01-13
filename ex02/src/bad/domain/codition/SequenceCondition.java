package bad.domain.codition;

import bad.domain.Movie;
import bad.domain.Screening;

public class SequenceCondition implements DiscountCondition{
    private int sequnece;

    @Override
    public boolean isDiscountable(Screening screening) {
        return this.sequnece == screening.getSequence();
    }
}
